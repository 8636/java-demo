package com.example.ThreadDemo;

import com.google.common.base.Stopwatch;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static final Stopwatch stopwatch = Stopwatch.createStarted();
    public static final ExecutorService executorPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws Exception {
        List<Future<String>> tasks = new ArrayList<>();
        tasks.add(executorPool.submit(new MyCallable("1", 1000L)));
        tasks.add(executorPool.submit(new MyCallable("2", 1050L)));

        List<String> results = new ArrayList<>();
        while (!tasks.isEmpty()) {
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).isDone()) {
                    results.add(tasks.get(i).get());
                    tasks.remove(i);
                    i--;
                }
            }
        }

        System.out.println("main[" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "] list=" + results);
        executorPool.shutdown();
    }

    private static final class MyCallable implements Callable<String> {
        private final String s;
        private final Long time;

        MyCallable(String s, Long time) {
            this.s = s;
            this.time = time;
        }

        @Override
        public String call() {
            try {
                Thread.sleep(time);
            } catch (Exception ignore) {
            }
            System.out.println(s + ":" + stopwatch.elapsed(TimeUnit.MILLISECONDS));
            return s;
        }
    }
}