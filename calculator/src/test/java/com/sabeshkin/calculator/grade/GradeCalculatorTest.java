package com.sabeshkin.calculator.grade;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.common.collect.ImmutableList;
import com.sabeshkin.calculator.dto.Result;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeCalculatorTest {

  GradeCalculator gradeCalculator;

  @BeforeEach
  void setUp() {
    gradeCalculator = new GradeCalculator();
  }

  /**
   * 1. Тест проверяет, что минимальная средняя оценка по 100 бальной системе можем быть равна 0.
   */
  @Test
  void averageMoreOrEqualMinZero() {
    ImmutableList<Grade> grades = ImmutableList.of(GradeHundredSystemImpl.ZERO, GradeHundredSystemImpl.ZERO,
                                                   GradeHundredSystemImpl.ZERO, GradeHundredSystemImpl.ZERO);
    Result result = gradeCalculator.calculateAverage(grades);
    Result expected = new Result(Optional.empty(),
                                 Optional.of(0));
    assertAll(
        () -> assertTrue(result.getValue()
                               .isPresent()),
        () -> assertTrue(expected.getValue()
                                 .get() >=
                             result.getValue()
                                   .get()));
  }

  /**
   * 1. Тест проверяет, что минимальная средняя оценка выше или равна 2.
   */
  @Test
  void averageMoreOrEqualMin() {
    ImmutableList<Grade> grades = ImmutableList.of(GradeFiveSystemImpl.TWO, GradeFiveSystemImpl.TWO,
                                                   GradeFiveSystemImpl.TWO, GradeFiveSystemImpl.TWO);
    Result result = gradeCalculator.calculateAverage(grades);
    Result expected = new Result(Optional.empty(),
                                 Optional.of(2));
    assertAll(
        () -> assertTrue(result.getValue()
                               .isPresent()),
        () -> assertTrue(expected.getValue()
                                 .get() >=
                             result.getValue()
                                   .get()));
  }


  /**
   * 2. Тест проверяет, что максимальная оценка ниже или равна 5.
   */
  @Test
  void averageLessOrEqualMax() {
    ImmutableList<Grade> grades = ImmutableList.of(GradeFiveSystemImpl.FIVE, GradeFiveSystemImpl.FIVE,
                                                   GradeFiveSystemImpl.FIVE, GradeFiveSystemImpl.FIVE);
    Result result = gradeCalculator.calculateAverage(grades);
    Result expected = new Result(Optional.empty(),
                                 Optional.of(5));
    assertAll(
        () -> assertTrue(result.getValue()
                               .isPresent()),
        () -> assertTrue(expected.getValue()
                                 .get() <=
                             result.getValue()
                                   .get()));
  }

  /**
   * 3. Тест проверяет, что пустой список выдаст неопределенный результат среднего. Т.к. отсутствие
   * оценок может говорить что студент, только приступил к обучению, а не то что он плох.
   */
  @Test
  void averageEmpty() {
    ImmutableList<Grade> grades = null;
    Result result = gradeCalculator.calculateAverage(grades);
    assertAll(
        () -> assertTrue(result.getException()
                               .isPresent()),
        () -> assertEquals(result.getException()
                                 .get()
                                 .getMessage(),
                           "Передан пустой список"),
        () -> assertFalse(result.getValue()
                                .isPresent())
    );
  }

  /**
   * 4. Тест проверяет что если вместо списка пришел null, то выдаст неопределенный результат
   * среднего.
   */
  @Test
  void averageNull() {
    ImmutableList<Grade> grades = null;
    Result result = gradeCalculator.calculateAverage(grades);
    assertAll(
        () -> assertTrue(result.getException()
                               .isPresent()),
        () -> assertEquals(result.getException()
                                 .get()
                                 .getMessage(),
                           "Передан пустой список"),
        () -> assertFalse(result.getValue()
                                .isPresent())
    );
  }

  /**
   * 5. Тест проверяет, что средняя оценка равна 4.
   */
  @Test
  void averageFour() {
    ImmutableList<Grade> grades = ImmutableList.of(GradeFiveSystemImpl.FOUR, GradeFiveSystemImpl.FOUR);
    Result result = gradeCalculator.calculateAverage(grades);
    Result expected = new Result(Optional.empty(),
                                 Optional.of(4));
    assertEquals(expected, result);
  }

}