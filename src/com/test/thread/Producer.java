package com.test.thread;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	protected BlockingQueue<String> queue;

	public Producer(BlockingQueue<String> theQueue) {
		this.queue = theQueue;
	}

	public void run() {
		try {
			int count = 0;
			while (true) {
				queue.put("sumit" + count);
				System.out.println("Producer : Queue size"
						+ queue.size());
				count++;
				Thread.sleep(500);
			}
		} catch (InterruptedException ex) {
			System.out.println("Producer interrupted"+ex.getMessage());
		}
	}

}
