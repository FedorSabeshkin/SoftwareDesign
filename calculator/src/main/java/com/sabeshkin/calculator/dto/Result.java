package com.sabeshkin.calculator.dto;

import java.util.Objects;
import java.util.Optional;

public class Result {

  private final Optional<Exception> exception;

  private final Optional<Integer> value;

  public Result(Optional<Exception> exception,
                Optional<Integer> value) {
    this.exception = exception;
    this.value = value;
  }

  public Optional<Integer> getValue() {
    return value;
  }

  public Optional<Exception> getException() {
    return exception;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Result result = (Result) o;
    return Objects.equals(exception, result.exception) && Objects.equals(value,
                                                                         result.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exception, value);
  }

}
