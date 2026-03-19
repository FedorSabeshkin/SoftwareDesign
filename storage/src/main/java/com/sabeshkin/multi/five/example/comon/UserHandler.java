package com.sabeshkin.multi.five.example.comon;

public class UserHandler {

  private String current;

  private String first;

  private String second;

  public UserHandler() {
    this.first = "first";
    this.second = "second";
    this.current = first;
  }

  public String getCurrent() {
    return current;
  }

  public void change() {
    if (current.equals(first)) {
      current = second;
      return;
    }
    current = first;
  }

}
