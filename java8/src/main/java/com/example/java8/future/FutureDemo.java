package com.example.java8.future;

import java.util.concurrent.*;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/19 10:01
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test();
        System.out.println("3");


    }

    public Future<String> pushPileStatus(String connector){
        return CompletableFuture.supplyAsync(() -> push(connector) );
    }

    public  String push(String connector){
        System.out.println("start push");
        return "";
    }
    public static void test() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(5000);
            System.out.println("222");
            return "Hello from Callable";
        });
//        while(!future.isDone()) {
//            System.out.println("Task is still not done...");
//            Thread.sleep(200);
//        }
//        System.out.println("Task completed! Retrieving the result");
//        String result = future.get();
//        System.out.println(result);

        executorService.shutdown();
    }
}
