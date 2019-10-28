package com.ymschool.learning.thread;


public class Runnable01 implements  Runnable {
   @Override
   public void run() {
      System.out.println("monkey");
   }

   public static void main(String[] args) {
      new Thread(new Runnable01()).start();
   }
}
