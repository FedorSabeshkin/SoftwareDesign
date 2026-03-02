package com.sabeshkin.payment.main;

import com.sabeshkin.payment.dto.BankAccount;

public class Application {

  public static void main(String[] args) {
    BankAccount bankAccount = new BankAccount(0);
    System.out.println("bankAccount init balance: " + bankAccount.getBalance());
    bankAccount.deposit(2);
    bankAccount.withdraw(1);
    System.out.println("bankAccount after operations: " + bankAccount.getBalance());
  }

}
