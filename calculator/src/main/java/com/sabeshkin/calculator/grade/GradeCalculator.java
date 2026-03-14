package com.sabeshkin.calculator.grade;

import com.sabeshkin.calculator.dto.Result;
import java.util.List;
import java.util.Optional;

public class GradeCalculator {

  public Result calculateAverage(List<Grade> grades) {
    boolean isEmptyArray = grades == null
        || grades.size() == 0;
    if (isEmptyArray) {
      Exception exception = new IllegalArgumentException("Передан пустой список");
      Optional<Exception> exceptionOptional = Optional.of(exception);
      return new Result(exceptionOptional,
                        Optional.empty());
    }
    int sum = grades.stream().mapToInt(grade -> grade.getNumberValue())
                    .sum();
    Integer value = sum / grades.size();
    Optional<Integer> valueOptional = Optional.of(value);
    return new Result(Optional.empty(),
                      valueOptional);
  }

}
