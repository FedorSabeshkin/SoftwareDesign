package com.sabeshkin.multi.five.example.locker;

import com.sabeshkin.multi.five.example.comon.UserHandler;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PropertyChanger {

  private final Lock lock = new ReentrantLock(); // 1. Объект Lock

  private final UserHandler userHandler;

  public PropertyChanger(UserHandler userHandler) {
    this.userHandler = userHandler;
  }

  public  void exec(String errorUsername) {
    lock.lock(); // 2. Захват
    try {
      System.out.println("Получена ошибка на username "+ errorUsername);
      String current = userHandler.getCurrent();
      if(errorUsername.equals(current)){
        System.out.println("Выполняем смену УЗ");
        userHandler.change();
      }
      System.out.println("Текущая УЗ " + userHandler.getCurrent());
    } finally {
      lock.unlock(); // 3. Обязательное освобождение
    }
  }

}
