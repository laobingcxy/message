package com.byd.message.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SnowFlake {
    private static final String MACHINE_ID = "01";

    private static SnowFlake snowFlake = null;

    private SnowFlake() {
    }

    public static void main(String[] args) {
        System.out.println(SnowFlake.getInstance().getNum());
    }

    public static SnowFlake getInstance() {
        if (snowFlake == null) {
            synchronized (SnowFlake.class) {
                if (snowFlake == null) {
                    snowFlake = new SnowFlake();
                }
                return snowFlake;
            }
        }
        return snowFlake;
    }


    private long sequence = 0L;

    private String lastTime = "";

    public synchronized Long getNum() {
        String nowTime = getTime();
        String machineId = MACHINE_ID;

        if (!lastTime.equals(nowTime)) {
            sequence = 0L;
            lastTime = nowTime;
            return Long.valueOf(new StringBuilder(nowTime).append(machineId).append(sequence).toString());
        }

        if (sequence < 99) {
            sequence = sequence + 1;
            return Long.valueOf(new StringBuilder(nowTime).append(machineId).append(sequence).toString());
        }

        while (lastTime.equals(nowTime)) {
            nowTime = getTime();
        }
        sequence = 0L;
        lastTime = nowTime;
        return Long.valueOf(new StringBuilder(nowTime).append(machineId).append(sequence).toString());
    }

    private String getTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmssSSS"));
    }
}