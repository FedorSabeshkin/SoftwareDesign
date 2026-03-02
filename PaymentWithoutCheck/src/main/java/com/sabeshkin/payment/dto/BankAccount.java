package com.sabeshkin.payment.dto;

/**
 * Банковский аккаунт. Проверок на неверные операции - нет.
 */
public class BankAccount {

  private double balance;

  /**
   * Банковский аккаунт. Проверок на неверные операции - нет.
   */
  public BankAccount(double balance) {
    this.balance = balance;
  }

  /**
   * Добавить сумму к балансу.
   */
  public boolean deposit(double depositAmount) {
    balance = balance + depositAmount;
    return true;
  }

  /**
   * Снять сумму с баланса.
   */
  public boolean withdraw(double withdrawAmount) {
    balance = balance - withdrawAmount;
    return true;
  }

  /**
   * Получить текущее значение баланса.
   */
  public double getBalance() {
    return balance;
  }

}
