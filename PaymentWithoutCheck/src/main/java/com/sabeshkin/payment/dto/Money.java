package com.sabeshkin.payment.dto;

/**
 * Класс для работы с деньгами.
 */
public class Money {

  private final double amount;

  /**
   * Класс для работы с деньгами.
   */
  private Money(double amount) {
    this.amount = amount;
  }

  public static Money fabric(double amount){
    if (amount < 0) {
      throw new IllegalArgumentException("Получается отрицательное кол-во денег.");
    }
    return new Money(amount);
  }


  public Money minus(Money money){
    double sumAmount = amount - money.getAmount();
    return fabric(sumAmount);
  }

  public Money plus(Money money){
    double sumAmount = amount + money.getAmount();
    return fabric(sumAmount);
  }

  /**
   * Получить текущее значение баланса.
   */
  public double getAmount() {
    return amount;
  }

}
