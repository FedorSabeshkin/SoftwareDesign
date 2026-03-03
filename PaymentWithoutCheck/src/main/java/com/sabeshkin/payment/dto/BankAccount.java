package com.sabeshkin.payment.dto;

/**
 * Банковский аккаунт. Проверок на неверные операции - нет.
 */
public class BankAccount {

  private Money balance;

  /**
   * Банковский аккаунт. Проверок на неверные операции - нет.
   */
  public BankAccount(Money balance) {
    this.balance = balance;
  }

  /**
   * Добавить сумму к балансу.
   */
  public void deposit(Money depositAmount) {
    balance =  balance.plus(depositAmount);
  }

  /**
   * Снять сумму с баланса.
   */
  public void withdraw(Money withdrawAmount) {
    balance = balance.minus(withdrawAmount);
  }

  /**
   * Получить текущее значение баланса.
   */
  public Money getBalance() {
    return balance;
  }

}
