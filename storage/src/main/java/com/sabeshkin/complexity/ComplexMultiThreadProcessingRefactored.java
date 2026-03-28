package com.sabeshkin.complexity;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ComplexMultiThreadProcessingRefactored {
    private static final int SIZE = 1_000_000;
    private static final int THREAD_AMOUNT = 4;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ForkJoinPool customPool = new ForkJoinPool(THREAD_AMOUNT);
        // всю сложность работы с потоками и изоляции выполнения операции делегирую функционалу Stream API,
        // которое может применять параллельность при использовании ключевого слова .parallel()
        int sum = customPool.submit(
                () -> IntStream.range(0, SIZE)
                        .parallel()
                        .map(x -> RANDOM.nextInt(100))
                        .sum()
        ).get();


        System.out.println("Sum of all elements: " + sum);
    }


}