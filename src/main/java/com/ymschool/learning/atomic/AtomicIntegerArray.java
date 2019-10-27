package com.ymschool.learning.atomic;

import sun.misc.Unsafe;

import java.io.Serializable;

/**
 * @program: jcstress
 * @description: AtomicIntegerArray的实现
 * @author: XUCHANG
 * @time: 2019/10/12 17:54
 */
public class AtomicIntegerArray implements Serializable {
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final int base = unsafe.arrayBaseOffset(int[].class);
    private static final int shift;
    private final int[] array = new int[0];
    static {
        int scale = unsafe.arrayIndexScale(int[].class);
        if((scale & (scale-1)) != 0 ){
            throw new Error("数据不合法");
        }
        shift = 31 - Integer.numberOfLeadingZeros(scale);
    }
    public final int getAndSet(int i,int newValue){
        return unsafe.getAndAddInt(array,checkByteOffset(i),newValue);
    }

    private int checkByteOffset(int i) {
        return 0;
    }
}
