package com.ymschool.learning.thread;


public class Thread01 extends Thread{

   @Override
   public void run() {
      System.out.println("hello");
   }

   public static void main(String[] args) throws InterruptedException {
      new Thread01().start();//多线程
     // Thread.sleep(Long.MAX_VALUE);
     //new Thread01().run();//1 0方法调用

   }
}
