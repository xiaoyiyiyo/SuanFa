package com.kingyi.unique_id;

/**
 * Created by xiaoyiyiyo on 2018/3/28.
 */
public class SnowFlake {

    //起始时间戳
    private final static long START_STMP = 1522251105535L;

    //每一部分占用的位数，共计64位，其中22位如下。41位用于时间戳，最高一位始终为0
    private final static long SEQUENCE_BIT = 12;    //序列号占用的位数
    private final static long MACHINE_BIT = 5;  //机器标识占用的位数
    private final static long DATACENTER_BIT = 5;   //数据中心占用的位数

    //每一部分的最大值
    private final static long NAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE_NUM = -1L ^ (-1L << SEQUENCE_BIT);
    private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);

    //每一部分所需左移位数
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTAMP_LEFT = SEQUENCE_BIT + MACHINE_BIT + DATACENTER_BIT;

    private long dataCenterId;
    private long machineId;
    private long sequence = 0L;
    private long lastStmp = -1L;

    public SnowFlake(long dataCenterId, long machineId) {
        if (dataCenterId > MAX_DATACENTER_NUM || dataCenterId < 0) {
            throw new IllegalArgumentException("dataCenterId can't be greater than " + MAX_DATACENTER_NUM
                + " or less than 0");
        }

        if (machineId > NAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than " + NAX_MACHINE_NUM
                    + " or less than 0");
        }

        this.dataCenterId = dataCenterId;
        this.machineId = machineId;
    }

    public synchronized long nextId() {
        long currentStmp = getNewStmp();
        if (currentStmp < lastStmp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate id.");
        }

        if (currentStmp == lastStmp) {
            sequence = (sequence + 1) & MAX_SEQUENCE_NUM;
            if (sequence == 0L) {
                currentStmp = getNewStmp();
            }
        } else {
            sequence = 0L;
        }

        lastStmp = currentStmp;
        return (currentStmp - START_STMP) << TIMESTAMP_LEFT
                | dataCenterId << DATACENTER_LEFT
                | machineId << MACHINE_LEFT
                | sequence;
    }

    private long getNewStmp() {
        long newStmp = System.currentTimeMillis();
        while(newStmp < lastStmp) {
            newStmp = System.currentTimeMillis();
        }
        return newStmp;
    }

    public static void main(String[] args) {
        SnowFlake snowFlake = new SnowFlake(2,3);
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < (1 << 8); i++ ) {
                    System.out.println(snowFlake.nextId());
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < (1 << 8); i++ ) {
                    System.out.println(snowFlake.nextId());
                }
            }
        }.start();
    }
}
