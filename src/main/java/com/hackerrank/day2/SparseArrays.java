package com.hackerrank.day2;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class SparseArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Integer> dictionary = IntStream.range(0, in.nextInt())
            .mapToObj(i -> in.next())
            .collect(groupingBy(x -> x))
            .entrySet()
            .stream()
            .collect(toMap(Map.Entry::getKey, e -> e.getValue().size()));
        IntStream.range(0, in.nextInt())
            .mapToObj(i -> in.next())
            .mapToInt(x -> ofNullable(dictionary.get(x)).orElse(0))
            .forEach(System.out::println);
    }
}
