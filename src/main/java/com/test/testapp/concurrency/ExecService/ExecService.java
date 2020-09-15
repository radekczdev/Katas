package com.test.testapp.concurrency.ExecService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecService {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static String result = "";

    public static void main(String... args) throws ExecutionException, InterruptedException {
        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        // Without any return info (only runnable)
        System.out.println("execute():");
        executorService.execute(runnableTask);

        // future enables to get information about execution of tasks
        System.out.println("submit():");
        Future<String> future = executorService.submit(callableTask);
        boolean isDone = false;
        while(!isDone) {
            isDone = future.isDone();
            result = future.get();
            System.out.println(String.format("isDone?: %b, result: %s", isDone, result));
        }

        // returns result from execution of one of successfully executed tasks
        System.out.println("invokeAny()");
        result = executorService.invokeAny(callableTasks);
        System.out.println(result);

        // returns result of all task executions
        System.out.println("invokeAll()");
        List<Future<String>> futures = executorService.invokeAll(callableTasks);
        futures.forEach(ExecService::getValue);

        // terminating executor
        // 1. stops taking new tasks with .shutdown()
        // 2. waits until timeout or all tasks are completed
        // 3. executes force .shutdownNow()
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

    }

    private static void getValue(Future<String> f) {
        try {
            System.out.println(f.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
