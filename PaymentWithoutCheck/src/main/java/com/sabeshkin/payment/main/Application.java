package com.sabeshkin.payment.main;

import com.sabeshkin.payment.dto.BankAccount;
import com.sabeshkin.payment.dto.Money;

public class Application {

  public static void main(String[] args) {
    Money initBalance = Money.fabric(0);
    BankAccount bankAccount = new BankAccount(initBalance);
    System.out.println("bankAccount init balance: " + bankAccount.getBalance().getAmount());
    Money depositAmount = Money.fabric(2);
    bankAccount.deposit(depositAmount);
    Money withdrawAmount = Money.fabric(1);
    bankAccount.withdraw(withdrawAmount);
    System.out.println("bankAccount after operations: " + bankAccount.getBalance().getAmount());
  }

}
