package com.example.functional_programming_with_java;

import org.springframework.boot.SpringApplication;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BehaviorParameterizationPratiques {
    public static void main(String[] args) {
        SpringApplication.run(FunctionalProgrammingWithJavaApplication.class, args);

List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, n -> n * n);
        List<Integer> cubedNumbers = mapAndCreateNewList(numbers, n -> n * n);
        List<Integer> doubledNumbers = mapAndCreateNewList(numbers, n -> n * n);

        System.out.println("Squared Numbers: " + squaredNumbers);
        System.out.println("Cubed Numbers: " + cubedNumbers);
        System.out.println("Doubled Numbers: " + doubledNumbers);
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }
}
