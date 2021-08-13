package com.byd.message.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.byd.message.domain.Message;
import com.byd.message.service.MessageService;
import com.byd.message.service.TdMessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
@Order(3)
@ServerEndpoint(value = "/90000001/{sender}/{apply}/{userId}")
public class MyWebSocket {

    private static final String NULL_KEY = "null";
    /**
     * 心跳连接有效时间(毫秒)
     */
    private static final Long BEAT_HEART_DURATION_TIME_MILLIS = 10 * 60 * 1000L;

    /**
     * 用来记录当前在线连接数
     */
    private static AtomicInteger onlineCount = new AtomicInteger(0);

    /**
     * concurrent包的线程安全Map，用来存放每个客户端对应的Session对象。
     */
    public static Map<String, Session> clients = new ConcurrentHashMap<String, Session>();

    /**
     * concurrent包的线程安全Map，用来存放每个客户端对应的Session对象。
     */
    private static Map<Session, String> sessionMap = new ConcurrentHashMap<Session, String>();

    private static Map<String, Session> oldClients = new ConcurrentHashMap<String, Session>();
    private static Map<String, Date> record = new ConcurrentHashMap<String, Date>();


    private static Map<Session, Long> sessionBeatheartMap = new ConcurrentHashMap<Session, Long>();


    @Autowired
    MessageService messageService;
    @Autowired
    TdMessageService tdMessageService;


    @OnOpen
    public void onOpen(
            @PathParam("sender") String sender,
            @PathParam("userId") String userId,
            @PathParam("apply") String apply,
            Session session) {
        if (StringUtils.isEmpty(userId) || NULL_KEY.equalsIgnoreCase(userId)) {
            try {
                log.warn("[key={}]非法,禁止连接！！！", userId);
                session.close();
            } catch (IOException e) {
            }
        }
        if (clients.containsKey(sender + ":" + apply)) {
            //删除原有连接
            destroyOldSession(sender + ":" + apply);
        }
        //在线数加1
        addOnlineCount();
        clients.put(sender + ":" + apply + ":" + userId, session);
        sessionMap.put(session, sender + ":" + apply + ":" + userId);
        sessionBeatheartMap.put(session, System.currentTimeMillis());
        log.info("加入新连接[userId={},sender={}]！当前在线连接数为{}", userId, sender, getOnlineCount());

    }

    @OnClose
    public void onClose(Session session, @PathParam("sender") String sender, @PathParam("apply") String apply) {
        String key = sessionMap.get(session);
        if (StringUtils.isNotEmpty(key)) {
            if (clients.containsKey(key)) {
                clients.remove(key);
                //在线数减1
                subOnlineCount();
            }
            sessionMap.remove(session);
            sessionBeatheartMap.remove(session);
            log.info("关闭连接[userId={}]关闭！当前在线连接数为{},移除key:{}", key, getOnlineCount(), key);
            record.remove(key);
            destroyOldSession(key);
        }
    }


    @Scheduled(cron = " */5 * * * * ?")
    public void processTerminalInformation() {
        if (clients.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Session> entry : clients.entrySet()) {
            String k = entry.getKey();
            Session v = entry.getValue();
            try {
                String[] sa = k.split(":");
                List<Message> messages = messageService.queryMessageByApplyAndSenderAndTime(sa[0], sa[1], record.get(k));
                log.info("实时推送新消息，key：{},size:{},time:{}", k, messages.size(), new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss").format(record.get(k)));
                if (CollectionUtil.isNotEmpty(messages)) {
                    for (Message m : messages) {
                        v.getAsyncRemote().sendText(JSON.toJSONString(m));
                    }
                    int lastE = messages.size() - 1;
                    record.put(k, messages.get(lastE).getTime());
                }
            } catch (Exception e) {
                destroyOldSession(k);
            }
        }
    }


    @Scheduled(cron = "0 */1 * * * ?")
    public void processOnlineTime() {

        oldClients.forEach((k, v) -> {
            try {
                Long lastBeatTime = sessionBeatheartMap.get(v);
                if (lastBeatTime == null || (System.currentTimeMillis() - lastBeatTime) > BEAT_HEART_DURATION_TIME_MILLIS) {
                    //超过90秒未收到空消息,KEY 设备已断开连接
                    destroyOldSession(k);
                }
            } catch (Exception e) {
                //连接不可用,清理连接
                destroyOldSession(k);
            }
        });
        oldClients = clients;
    }


    private void destroyOldSession(String key) {
        Session oldSession = clients.get(key);
        if (oldSession != null) {
            if (clients.containsKey(key)) {
                subOnlineCount();
                clients.remove(key);
                if (oldSession != null) {
                    sessionMap.remove(oldSession);
                    sessionBeatheartMap.remove(oldSession);
                }
                try {
                    oldSession.close(new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "已断开连接!"));
                } catch (IOException e) {
                }
            }
        }
    }


    public static synchronized AtomicInteger getOnlineCount() {
        return onlineCount;
    }

    /**
     * 增加连接人数
     */
    public static synchronized void addOnlineCount() {
        onlineCount.incrementAndGet();
    }

    /**
     * 减少连接人数
     */
    public static synchronized void subOnlineCount() {
        onlineCount.decrementAndGet();
    }

    public static Map<String, Date> getRecord() {
        return record;
    }

    public static void setRecord(Map<String, Date> record) {
        MyWebSocket.record = record;
    }


}
