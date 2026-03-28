package com.sabeshkin.hoar.first;

public class MaxAbs {

  int max(int x,
          int y) {
    if (x == y) {
      throw new IllegalArgumentException("Аргументы равны");
    }
    if (x > y) {
      return x;
    }
    return y;
  }

  int abs(int x) {
    if (x < 0) {
      return x * (-1);
    }
    return x;
  }

  int maxAbs(int x,
             int y) {
    int xAbs = abs(x);
    int yAbs = abs(y);
    return max(xAbs, yAbs);
  }

}
