package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {

        /*
        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);
        */

    }

    public static IntStream cycleGrayCode(int n) {
        int size = 1 << n; // 2^n

        return IntStream.iterate(0, i -> (i + 1) % size)
            .map(i -> i ^ (i >>> 1)); // преобразуем в Gray code
    }
}
