package com.sabeshkin.calculator.grade;

/**
 * Оценки.
 */
public enum Grade {

  TWO(2),

  THREE(3),

  FOUR(4),

  FIVE(5);

  private final int numberValue;

  Grade(int numberValue) {
    this.numberValue = numberValue;
  }

  public int getNumberValue() {
    return numberValue;
  }
}
