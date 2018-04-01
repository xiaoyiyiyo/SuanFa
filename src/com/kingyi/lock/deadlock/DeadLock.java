package com.kingyi.lock.deadlock;

public class DeadLock {
    private static Object locka = new Object();
    private static Object lockb = new Object();

    private void createDeadLock(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(locka){
                    System.out.println(Thread.currentThread().getName()+ " get the locka");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " try to get the lockb");
                    synchronized(lockb){
                        System.out.println(Thread.currentThread().getName() + " get the lockb");
                    }
                }
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockb) {
                    System.out.println(Thread.currentThread().getName() + " get the lockb");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " try to get the locka");
                    synchronized (locka) {
                        System.out.println(Thread.currentThread().getName() + " get the locka");
                    }
                }
            }
        }, "thread2");

        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        new DeadLock().createDeadLock();
    }
}
