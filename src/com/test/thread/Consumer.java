package com.test.thread;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	protected BlockingQueue<String> queue;

	public Consumer(BlockingQueue<String> theQueue) {
		this.queue = theQueue;
	}

	public void run() {

		try {
			while (true) {
				String data = queue.take();
				System.out.println("Data consumer is:" + data);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Consumer - Queue size: "
				+ queue.size());

	}

}
