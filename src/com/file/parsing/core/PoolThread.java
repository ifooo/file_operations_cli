package com.file.parsing.core;

import java.nio.file.Path;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolThread {
	void execute(Path[] args, FileOperationsPattern fileOperationsPattern) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i = 0; i < args.length; i++) {
			Runnable worker = new FileOperations(fileOperationsPattern,
					args[i]);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		long time = System.currentTimeMillis();
		System.out.println("Finished all threads at " + new Date(time));
	}
}
