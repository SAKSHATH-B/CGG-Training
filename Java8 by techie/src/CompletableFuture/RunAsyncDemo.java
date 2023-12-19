package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunAsyncDemo {

  public static void main(String[] args)
    throws InterruptedException, ExecutionException {
    //Two ways to use runAsync method of completableFuture which return void
    //1.using runnable anonymous function
    //if we provide executor then it will provide the threads to execute the method or else the central forkJoinPool will provide the threads to run the methods

    ExecutorService executor = Executors.newFixedThreadPool(1);

    // CompletableFuture<Void> runAsync1 = CompletableFuture.runAsync(
    //   new Runnable() {
    //     @Override
    //     public void run() {
    //       System.out.println("Thread : " + Thread.currentThread().getName());
    //       System.out.println("This is using runnable anonymous function");
    //     }
    //   },
    //   executor
    // );
    // runAsync1.get();

    //2.using runnable lambda expression

    CompletableFuture<Void> runAsync2 = CompletableFuture.runAsync(
      () -> System.out.println("This is runnable in runAsync"),
      executor
    );
    runAsync2.toCompletableFuture();
    runAsync2.get();
  }
}
