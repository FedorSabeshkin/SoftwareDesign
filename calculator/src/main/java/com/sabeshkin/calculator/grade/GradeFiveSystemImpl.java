package com.sabeshkin.calculator.grade;

/**
 * Оценки по 5 бальной системе.
 */
public enum GradeFiveSystemImpl
    implements Grade{

  TWO(2),

  THREE(3),

  FOUR(4),

  FIVE(5);

  private final int numberValue;

  GradeFiveSystemImpl(int numberValue) {
    this.numberValue = numberValue;
  }

  @Override
  public int getNumberValue() {
    return numberValue;
  }
}
