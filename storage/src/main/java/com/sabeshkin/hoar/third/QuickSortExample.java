package com.sabeshkin.hoar.third;

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuickSortExample {

  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  public static void main(String[] args) {
    int[] array = {10, 7, 8, 9, 1, 5};
    quickSort(array, 0, array.length - 1);

    for (int i : array) {
      System.out.print(i + " ");
    }
  }

  public static void quickSort(int[] source,
                               int leftBorder,
                               int rightBorder) {
    boolean isSorted = leftBorder >= rightBorder;
    if (isSorted) {
      return;
    }
    LOGGER.info("Ищем опорный элемент.");
    int pivot = getPivot(source, leftBorder, rightBorder);
    LOGGER.info("Нашли опорный элемент.");

    int leftIndex = leftBorder;
    int rightIndex = rightBorder;


    LOGGER.info("Начинаем разделения массива.");
    while (leftIndex <= rightIndex) {
      leftIndex = getLeftIndex(source, pivot, leftIndex);
      rightIndex = getRightIndex(source, pivot, rightIndex);

      if (leftIndex <= rightIndex) {
        LOGGER.info("Необходимо перемещение элемента.");
        changeElementPosition(source, leftIndex, rightIndex);
        LOGGER.info("Массив после перемещения {}.", source);
        leftIndex = stepToRight(leftIndex);
        rightIndex = stepToLeft(rightIndex);
      }
    }
    LOGGER.info("Выполнили разделения массива.");

    boolean isNeedMoveToLeft = leftBorder < rightIndex;
    if (isNeedMoveToLeft) {
      LOGGER.info("Необходим рекурсивный вызов для левой части.");
      quickSort(source, leftBorder, rightIndex);
    }
    boolean isNeedMoveToRight = rightBorder > leftIndex;
    if (isNeedMoveToRight) {
      LOGGER.info("Необходим рекурсивный вызов для правой части.");
      quickSort(source, leftIndex, rightBorder);
    }
  }

  /**
   * Ищем элемент слева, который должен быть справа от pivot.
   */
  private static int getLeftIndex(int[] source,
                                  int pivot,
                                  int leftIndex) {
    while (source[leftIndex] < pivot) {
      LOGGER.info("Сдвигаем индекс вправо в поиске элемента source[leftIndex] < pivot.");
      leftIndex = stepToRight(leftIndex);
    }
    return leftIndex;
  }

  /**
   * Ищем элемент слева, который должен быть слева от pivot.
   */
  private static int getRightIndex(int[] source,
                                   int pivot,
                                   int rightIndex) {
    while (source[rightIndex] > pivot) {
      LOGGER.info("Сдвигаем индекс влево в поиске элемента source[leftIndex] > pivot.");
      rightIndex = stepToLeft(rightIndex);
    }
    return rightIndex;
  }

  /**
   * Сдвигаем правый индекс влево на 1 шаг.
   *
   * @param rightIndex изначальное значение правого индекса.
   * @return значение уменьшенное (сдвинутое влево) на 1.
   */
  private static int stepToLeft(int rightIndex) {
    rightIndex = rightIndex - 1;
    return rightIndex;
  }


  /**
   * Сдвигаем левый индекс вправо на 1 шаг.
   *
   * @param leftIndex изначальное значение левого индекса.
   * @return значение увеличенно (сдвинутое вправо) на 1.
   */
  private static int stepToRight(int leftIndex) {
    leftIndex = leftIndex + 1;
    return leftIndex;
  }

  /**
   * Меняет местами правый и левый элементы.
   *
   * @param source     исходный массив.
   * @param leftIndex  индекс изначально левого элемента.
   * @param rightIndex индекс изначально правого элемента.
   */
  private static void changeElementPosition(int[] source,
                                            int leftIndex,
                                            int rightIndex) {
    int leftElement = source[leftIndex];
    int rightElement = source[rightIndex];
    source[leftIndex] = rightElement;
    source[rightIndex] = leftElement;
  }

  /**
   * Выбор опорного элемента.
   *
   * @param source исходный массив.
   * @return индекс опорного элемента.
   */
  private static int getPivot(int[] source,
                              int leftBorder,
                              int rightBorder) {
    int medium = (leftBorder + rightBorder) / 2;
    int pivot = source[medium];
    return pivot;
  }

}
