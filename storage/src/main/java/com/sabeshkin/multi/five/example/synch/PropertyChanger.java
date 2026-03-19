package com.sabeshkin.multi.five.example.synch;

import com.sabeshkin.multi.five.example.comon.UserHandler;

public class PropertyChanger {

  private final UserHandler userHandler;

  public PropertyChanger(UserHandler userHandler) {
    this.userHandler = userHandler;
  }

  public synchronized void exec(String errorUsername) {

    System.out.println("Получена ошибка на username "+ errorUsername);
    String current = userHandler.getCurrent();
    if(errorUsername.equals(current)){
      System.out.println("Выполняем смену УЗ");
      userHandler.change();
    }
    System.out.println("Текущая УЗ " + userHandler.getCurrent());
  }

}
