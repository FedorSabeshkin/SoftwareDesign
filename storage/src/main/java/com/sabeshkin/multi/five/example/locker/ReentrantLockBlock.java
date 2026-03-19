package com.sabeshkin.multi.five.example.locker;

import com.sabeshkin.multi.five.example.comon.UserHandler;

public class ReentrantLockBlock {

  public static void main(String[] args) {
    UserHandler userHandler = new UserHandler();
    PropertyChanger propertyChanger = new PropertyChanger(userHandler);
    // парсим из ошибки username на котором она произошла
    // ...
    String errorUsername = "first";

    Runnable change = () -> propertyChanger.exec(errorUsername);

    int numberOfThreads = 10;
    Thread[] threads = new Thread[numberOfThreads];

    for (int i = 0; i < numberOfThreads; i++) {
      threads[i] = new Thread(() -> {
        change.run();
      });
    }
    for (int i = 0; i < numberOfThreads; i++) {
      threads[i].start();
    }
  }


}
