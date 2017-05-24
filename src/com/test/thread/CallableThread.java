package com.test.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableThread implements Callable<String> {

	@Override
	public String call() throws Exception {
		String name = Thread.currentThread().getName();
		return name;
	}

	public static void main(String args[]) {

		executeCallableThreadInFixedPool();
	}

	public static void executeCallableThreadInFixedPool() {
		ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<String>> list = new ArrayList<Future<String>>();
        Callable<String> callable = new CallableThread();
        for(int i=0; i< 10; i++){
            Future<String> future = executor.submit(callable);
            list.add(future);
        }
        for(Future<String> fut : list){
            try {
                    System.out.println(fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        executor.shutdown();
	}

}
