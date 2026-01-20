package com.example.functional_programming_with_java;

import org.springframework.boot.SpringApplication;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        SpringApplication.run(FunctionalProgrammingWithJavaApplication.class, args);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Predicate<Integer> isEvenPredicate = number -> number % 2 == 0;

        // Example usage of Predicate
        //take (input) integer and return (output) integer
        Function<Integer, Integer> squareFunction = number -> number * number;

        // Example usage of Predicate
        //take (input) integer and return (output) string
        Function<Integer, String> squareFunction2 = number -> number + "";

        // Example usage of Consumer
        //take (input) integer and return nothing (void)
        Consumer<Integer> printConsumer = x -> System.out.println(x);



    }
}