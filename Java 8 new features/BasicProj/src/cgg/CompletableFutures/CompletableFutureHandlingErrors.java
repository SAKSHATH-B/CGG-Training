package cgg.CompletableFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureHandlingErrors {

  public static void main(String[] args)
    throws InterruptedException, ExecutionException {
    String name = "sean";
    CompletableFuture<String> handle = CompletableFuture
      .supplyAsync(() -> {
        if (name == null) {
          throw new RuntimeException("Compilation Error");
        }
        return "Hello," + name;
      })
      .handle((s, t) -> s != null ? s : "Hello,Stranger!");

    System.out.println(handle.get());
  }
}
