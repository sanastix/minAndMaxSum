package com.sana;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

//Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
//Then print the respective minimum and maximum values as a single line of two space-separated long integers.

class Result {

    public static void miniMaxSum(List<Integer> arr) {
        List<Long> numbers = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            numbers.add(i, Long.valueOf(arr.get(i)));
        }

        List<Long> num = new ArrayList<>() {{
            add(numbers.get(1) + numbers.get(2) + numbers.get(3) + numbers.get(4));
            add(numbers.get(0) + numbers.get(2) + numbers.get(3) + numbers.get(4));
            add(numbers.get(0) + numbers.get(1) + numbers.get(3) + numbers.get(4));
            add(numbers.get(0) + numbers.get(1) + numbers.get(2) + numbers.get(4));
            add(numbers.get(0) + numbers.get(1) + numbers.get(2) + numbers.get(3));
        }};
        long min = 0, max = 0;

        for (Long aLong : num) {
            if (aLong > max) {
                max = aLong;
                if (min == 0) {
                    min = max;
                }
            }
            if (aLong < min) {
                min = aLong;
            }
        }
        System.out.print(min + " " + max);

    }

}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();

    }
}
