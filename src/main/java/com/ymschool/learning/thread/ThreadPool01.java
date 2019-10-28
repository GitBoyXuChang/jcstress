package com.ymschool.learning.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPool01 implements  Runnable {
   public static void main(String[] args) {
      ExecutorService executorService = Executors.newCachedThreadPool();
      //executorService.submit(()->   System.out.println("monkey"));
      executorService.execute(new ThreadPool01());
 /*     executorService.submit(new Runnable() {
         @Override
         public void run() {

            System.out.println("monkey");
         }
      });*/
      executorService.shutdown();
   }

   @Override
   public void run() {
      System.out.println("abc");
   }
}
