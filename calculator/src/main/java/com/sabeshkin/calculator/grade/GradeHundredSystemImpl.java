package com.sabeshkin.calculator.grade;

/**
 * Оценки по 100 бальной системе.
 */
public enum GradeHundredSystemImpl
    implements Grade{

  ZERO(0),

  TEN(10),

  TWENTY(20),

  THIRTY(30),

  FORTY(40),

  FIFTY(50),

  SIXTY(60),

  SEVENTY(70),

  EIGHTY(80),

  NINETY(90),

  HUNDRED(100);

  private final int numberValue;

  GradeHundredSystemImpl(int numberValue) {
    this.numberValue = numberValue;
  }

  @Override
  public int getNumberValue() {
    return numberValue;
  }
}
