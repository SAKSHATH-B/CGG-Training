package cgg.CompletableFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {

  public static void main(String[] args)
    throws InterruptedException, ExecutionException {
    CompletableFuture<String> thenCompose = CompletableFuture
      .supplyAsync(() -> "Hello")
      .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "World!"));
    System.out.println(thenCompose.get());

    System.out.println("----------------------------------------------");

    CompletableFuture<String> thenCombine = CompletableFuture
      .supplyAsync(() -> "Hello")
      .thenCombine(
        CompletableFuture.supplyAsync(() -> "Man!"),
        (s1, s2) -> s1 + s2
      );
    System.out.println(thenCombine.get());

    System.out.println("----------------------------------------------");

    CompletableFuture<Void> thenAcceptBoth = CompletableFuture
      .supplyAsync(() -> "John")
      .thenAcceptBoth(
        CompletableFuture.supplyAsync(() -> "Wick"),
        (s1, s2) -> System.out.println(s1 + s2)
      );
    System.out.println(thenAcceptBoth);
  }
}
