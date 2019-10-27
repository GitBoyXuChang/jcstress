package com.ymschool.learning.atomic;

import com.sun.org.apache.xpath.internal.operations.Number;
import sun.misc.Unsafe;

import java.io.Serializable;

/**
 * @program: jcstress
 * @description: AtomicInteger的实现
 * @author: XUCHANG
 * @time: 2019/10/11 17:41
 *
 * public class AtomicInteger {
 *     private volatile int value;
 *
 *     public void add(int v) {
 *         int oldValue;
 *         do {
 *             oldValue = value;
 *         }while( !cas(OldValue, old+v) ;
 *     }
 * }
 *
 */
public class AtomicInteger extends Number implements Serializable {
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));
        }catch (Exception e){
            throw new Error(e);
        }
    }
    public final int getAndAdd(int delta){
        return unsafe.getAndAddInt(this,valueOffset,delta);
    }
    public final int getAndIncrement(){
        return unsafe.getAndAddInt(this,valueOffset,1);
    }
}
