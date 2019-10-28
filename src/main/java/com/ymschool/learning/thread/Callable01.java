package com.ymschool.learning.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class Callable01 implements Callable<String> {
   @Override
   public String call() throws Exception {
      System.out.println("monkey");
      return "hello";
   }

   public static void main(String[] args) throws ExecutionException, InterruptedException {
      FutureTask task=new FutureTask(new Callable01());//有参 赋值 成员属性
      new Thread(task).start();
      System.out.println( task.get());;

   }
}
