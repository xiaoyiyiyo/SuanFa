package com.kingyi.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xiaoyiyiyo on 2018/4/1.
 */
public class Pool {

    private static final int MAX_AVAILABLE = 2;
    private Object items[] = new Object[MAX_AVAILABLE];
    private boolean used[] = new boolean[MAX_AVAILABLE];

    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);
    private final ReentrantLock getLock = new ReentrantLock(true);
    private final ReentrantLock putLock = new ReentrantLock(true);

    public Object getItem() throws InterruptedException {
        available.acquire();
        return getNextAvailableItem();
    }

    public void putItem(Object item) {
        if (markAsUnused(item)) {
            available.release();
        }
    }

    private Object getNextAvailableItem() {
        try {
            getLock.lock();
            for (int i = 0; i < MAX_AVAILABLE; i++) {
                if (!used[i]) {
                    used[i] = true;
                    System.out.println("Have got item i = " + i);
                    return items[i];
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            getLock.unlock();
        }

    }

    private boolean markAsUnused(Object item) {
        try {
            putLock.lock();
            for (int i = 0; i < MAX_AVAILABLE; i++) {
                if (item == items[i]) {
                    if (used[i]) {
                        used[i] = false;
                        System.out.println("Release item i = " + i);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            putLock.unlock();
        }
    }

    public static void main(String[] args) {
        Pool pool = new Pool();
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("========  B");
                    Object obj = pool.getItem();
                    Thread.sleep(5000);
                    pool.putItem(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("========  A");
                    pool.getItem();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("========  C");
                    pool.getItem();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
