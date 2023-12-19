package CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class WhyNotFuture {

  public static void main(String[] args)
    throws InterruptedException, ExecutionException {
    ExecutorService service = Executors.newFixedThreadPool(10);
    Future<List<Integer>> future1 = service.submit(() -> {
      System.out.println("Thread :" + Thread.currentThread().getName());
      System.out.println(10 / 0);
      return Arrays.asList(1, 2, 3, 4);
    });

    List<Integer> list = future1.get();
    System.out.println(list);

    //Completable futures
    CompletableFuture<String> completableFuture = new CompletableFuture<>();
    completableFuture.get(); //--if get method makes much time to execute we can stop the run state by complete method and pass a string message
    completableFuture.complete("success");
  }

  private static void delay(int min) {
    try {
      TimeUnit.MINUTES.sleep(min);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
//disadvantages
//we cannot stop the future manually
//we cannot pass the future as argument to another future
//we cannot join multiple futures
//no proper handling exceptions of futures
