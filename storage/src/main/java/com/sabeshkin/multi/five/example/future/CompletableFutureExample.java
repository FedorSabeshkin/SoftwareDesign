package com.sabeshkin.multi.five.example.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

public class CompletableFutureExample {

  public static void main(String[] args) throws
      InterruptedException {
    // Выполнение асинхронной задачи

    final UserService userService = new UserService();
    final LotteryService lotteryService = new LotteryService();
    CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
                                                        sleepRandom();
                                                        return 123;
                                                      })
                                                      .thenApply(
                                                          result -> {
                                                            sleepRandom();
                                                            int userId = userService.generateId(
                                                                result);
                                                            System.out.println(
                                                                "Сгенерирован userId " + userId);
                                                            return userId;
                                                          })
                                                      .thenApply(userId -> {
                                                        sleepRandom();
                                                        System.out.println(
                                                            "Вы участвуете в лотерее " + userId);
                                                        return lotteryService.play(userId);
                                                      })
                                                      .thenAccept(
                                                          isWin -> {

                                                            String message =
                                                                isWin ? "выиграли брелок!"
                                                                    : "ничего не выиграли";
                                                            System.out.println(
                                                                "Вы " + message);
                                                          }
                                                      );

    System.out.println("Задача отправлена на выполнение");

    // Блокируем выполнение текущего потока до завершения задачи
    try {
      future.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    sleep(2000);
  }

  static void sleep(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }
  }

  public static void sleepRandom() {
    try {
      long randomMillis = ThreadLocalRandom.current()
                                           .nextLong(100, 2000);
      Thread.sleep(randomMillis);
    } catch (InterruptedException e) {
      Thread.currentThread()
            .interrupt();
      System.err.println("Поток был прерван во время сна");
    }
  }

}