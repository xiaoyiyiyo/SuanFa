package com.kingyi.lock.deadlock.socket_dead;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by xiaoyiyiyo on 2018/3/27.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        testDead();
    }

    public static void testDead() throws IOException {
        int count = 0;
        Socket s = new Socket("localhost", 6060);
        while (true) {
            s.getOutputStream().write(new byte[1024 * 8]);
            s.getInputStream().read();
            System.out.println("client: " + ++count);
        }
    }
}
