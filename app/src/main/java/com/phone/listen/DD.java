package com.phone.listen;

public class DD {

    // 钉钉消息
    public static void send(String message_con) {
        Thread thread = new MyThread3(message_con);
        thread.start();
    }

}