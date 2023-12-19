package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureMethods {

  public static void main(String[] args)
    throws InterruptedException, ExecutionException {
    // CompletableFuture<Void> cf1 = CompletableFuture
    //   .supplyAsync(() -> {
    //     int num = 2;
    //     System.out.println("Thread 1 : " + Thread.currentThread().getName());
    //     return num * num;
    //   })
    //   //thenApply will take a function with one argument and returns the result as per the input. There is no concept of asynchronous threads in thenApply and all tasks are running in a single thread. if we want to run tasks in more threads then we should use thenApplyAsync method.
    //   .thenApply(e -> {
    //     int cube = e * e * e;
    //     System.out.println("Thread 2 : " + Thread.currentThread().getName());
    //     return cube;
    //   })
    //   //thenAccept will takes a consumer with one argument and will return nothing
    //   .thenAccept(e -> {
    //     System.out.println("Thread 3 : " + Thread.currentThread().getName());
    //     System.out.println("Cube of squared number is : " + e);
    //   })
    //   .thenRun(() -> {
    //     System.out.println("Thread 4 : " + Thread.currentThread().getName());
    //     System.out.println("I am good in then run");
    //   });

    // cf1.get();

    ExecutorService executor = Executors.newFixedThreadPool(2);

    CompletableFuture<Void> cf2 = CompletableFuture
      .supplyAsync(
        () -> {
          int num = 2;
          System.out.println("Thread 1 : " + Thread.currentThread().getName());
          return num * num;
        },
        executor
      )
      //thenApply will take a function with one argument and returns the result as per the input. There is no concept of asynchronous threads in thenApply and all tasks are running in a single thread. if we want to run tasks in more threads then we should use thenApplyAsync method.
      .thenApplyAsync(
        e -> {
          int cube = e * e * e;
          System.out.println("Thread 2 : " + Thread.currentThread().getName());
          return cube;
        },
        executor
      )
      //thenAccept will takes a consumer with one argument and will return nothing
      .thenAcceptAsync(
        e -> {
          System.out.println("Thread 3 : " + Thread.currentThread().getName());
          System.out.println("Cube of squared number is : " + e);
        },
        executor
      )
      .thenRunAsync(
        () -> {
          System.out.println("Thread 4 : " + Thread.currentThread().getName());
          System.out.println("I am good in then run");
        },
        executor
      );

    cf2.get();
  }
}
