package com.ymschool.learning.thread;

import java.util.concurrent.*;

/***
 * 拒绝策略测试
 * RejectedExecutionHandler
 */
public class RejectThreadPoolDemo {
	public static class MyTask implements Runnable {
		@Override
		public void run() {
			System.out.println(System.currentTimeMillis() + ":Thread ID:"
					+ Thread.currentThread().getId());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyTask task = new MyTask();
		ExecutorService es = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler(){
					@Override
					public void rejectedExecution(Runnable r,
							ThreadPoolExecutor executor) {
						throw new RejectedExecutionException("我不爽 " + r.toString() +
								" rejected from "
							);
					}
		});
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			es.submit(task);
			Thread.sleep(10);
		}
	}
}
