package com.sabeshkin.calculator.general;

import com.sabeshkin.calculator.dto.Result;
import java.util.Arrays;
import java.util.Optional;

public class AverageCalculator {

  public Result calculateAverage(int[] numbers) {
    boolean isEmptyArray = numbers == null
        || numbers.length == 0;
    if (isEmptyArray) {
      Exception exception = new IllegalArgumentException("Передан пустой массив");
      Optional<Exception> exceptionOptional = Optional.of(exception);
      return new Result(exceptionOptional,
                        Optional.empty());
    }
    int sum = Arrays.stream(numbers)
                    .sum();
    Integer value = sum / numbers.length;
    Optional<Integer> valueOptional = Optional.of(value);
    return new Result(Optional.empty(),
                      valueOptional);
  }

}
