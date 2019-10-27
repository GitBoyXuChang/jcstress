package com.ymschool.learning.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: jcstress
 * @description:原子更新变量-AtomicInteger
 * @author: XUCHANG
 * @time: 2019/10/27 17:33
 */
public class AtomicIntegerTest {
    private AtomicInteger count = new AtomicInteger();
    public void increment(){
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
class Test1{
    private volatile int count = 0 ;
    public synchronized void increment(){
        count ++;
    }

    public int getCount() {
        return count;
    }
}
