package cgg.concurrencyAPI;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletavleCompletedFuture {

  public static void main(String[] args)
    throws InterruptedException, ExecutionException {
    CompletableFuture<String> completedFuture = CompletableFuture.completedFuture(
      "Hello Man"
    );
    String result = completedFuture.get();
    System.out.println(result);
  }
}
