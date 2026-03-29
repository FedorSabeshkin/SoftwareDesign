package com.sabeshkin.hoar.third;

import static com.sabeshkin.hoar.third.QuickSortExample.quickSort;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuickSortExampleTest {

  @Test
  void sort() {
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");
    int[] array = {1};
    quickSort(array, 0, array.length - 1);
    assertArrayEquals(new int[]{1}, array);
  }

}