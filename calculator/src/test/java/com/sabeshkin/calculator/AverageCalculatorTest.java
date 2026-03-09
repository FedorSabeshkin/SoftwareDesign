package com.sabeshkin.calculator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sabeshkin.calculator.dto.Result;
import com.sabeshkin.calculator.general.AverageCalculator;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class AverageCalculatorTest {

  AverageCalculator averageCalculator;

  @BeforeEach
  void setUp() {
    averageCalculator = new AverageCalculator();
  }


  @Disabled("Ошибка на уровне согласования интерфейсов и точности вычислений.")
  @Test
  void testAverageDouble() {
    int[] numbers = {1, 2};
    Result result = averageCalculator.calculateAverage(numbers);
    assertEquals(Double.valueOf(1.5), result.getValue().get());
  }

  @Test
  void testAverage() {
    int[] numbers = {1, 2};
    Result result = averageCalculator.calculateAverage(numbers);
    Result expected = new Result(Optional.empty(),
                                 Optional.of(1));
    assertEquals(expected, result);
  }

  @ParameterizedTest()
  @MethodSource("emptyNumbers")
  void testEmptyArray(int[] numbers) {
    Result result = averageCalculator.calculateAverage(numbers);
    assertAll(
        () -> assertTrue(result.getException()
                                 .isPresent()),
        () -> assertEquals(result.getException()
                                   .get()
                                   .getMessage(),
                           "Передан пустой массив"),
        () -> assertFalse(result.getValue()
                                  .isPresent())
    );
  }

  static Stream<int[]> emptyNumbers() {
    return Stream.of(new int[]{}, null);
  }

}