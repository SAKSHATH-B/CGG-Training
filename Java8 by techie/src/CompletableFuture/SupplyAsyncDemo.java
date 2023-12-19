package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SupplyAsyncDemo {

  public static void main(String[] args)
    throws InterruptedException, ExecutionException {
    ExecutorService exec = Executors.newCachedThreadPool();
    CompletableFuture<String> supplyAsync1 = CompletableFuture.supplyAsync(
      () -> {
        System.out.println("Thread : " + Thread.currentThread().getName());
        System.out.println("I am from supplyAsync");
        return null;
      },
      exec
    );
    supplyAsync1.get();
  }
}
