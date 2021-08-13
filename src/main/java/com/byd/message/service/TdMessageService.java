package com.byd.message.service;

import com.byd.message.domain.MyReplyMessage;
import com.byd.message.domain.Result;
import com.byd.message.entity.TdMessage;

/**
 * 应用消息表(TdMessage)表服务接口
 *
 * @author makejava
 * @since 2021-07-16 14:12:16
 */
public interface TdMessageService {

    /**
     * 通过ID查询单条数据
     *
     * @param messageId 主键
     * @return 实例对象
     */
    TdMessage queryById(Long messageId);

    /**
     * @param page
     * @param size
     * @return
     */
    Result queryMessage(int page, int size, String id);

    /**
     * 新增数据
     *
     * @param tdMessage 实例对象
     * @return 实例对象
     */
    TdMessage insert(TdMessage tdMessage);

    /**
     * 修改数据
     *
     * @param tdMessage 实例对象
     * @return 实例对象
     */
    TdMessage update(TdMessage tdMessage);

    /**
     * 通过主键删除数据
     *
     * @param messageId 主键
     * @return 是否成功
     */
    boolean deleteById(String messageId);

    Result queryMessageByApplyAndSender(int page,String sender, String apply);

    Result saveMessageReply(MyReplyMessage replyMessage);
}
