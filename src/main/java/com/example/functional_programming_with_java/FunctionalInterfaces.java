package com.example.functional_programming_with_java;

import org.springframework.boot.SpringApplication;

import java.util.List;
import java.util.function.*;

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

        // Example usage of BinaryOperator
        // It called Binary because it takes two inputs of the same type
        //take (input) two integers and return (output) integer
        BinaryOperator<Integer> sumBinaryOperator = (x,y)-> x + y;

        // Example usage of UnaryOperator
        // It called Unary because it takes one input of the same type
        //take (input) one integer and return (output) integer
        UnaryOperator<Integer> unaryOperator = x -> x * x;
        System.out.println(unaryOperator.apply(10));


        //No input and return something
        Supplier<Integer> randomIntegerSupplier = () -> 2;
        //or
        Supplier<Double> randomIntegerSupplier2 = () -> {
            return  (Math.random() * 100);
        };
        System.out.println(randomIntegerSupplier.get());

        // Example usage of BiPredicate
        //take (input) integer and string and return (output) boolean
        //It called Bi because it takes two inputs of different types
        BiPredicate<Integer, String> biPredicate = (number, str) -> {
            return str.length() == number;
        };
        System.out.println(biPredicate.test(10,"reda"));

        // Example usage of BiConsumer
        //take (input) integer and string and return nothing (void)
        //It called Bi because it takes two inputs of different types
        BiFunction<Integer, String, String> biFunction = (number, str) -> {
            return str +" "+ number;
        };
        System.out.println(biFunction.apply(10,"reda"));

        BiConsumer<Integer, String> biConsumer = (number, str) -> {
            System.out.println(str +" "+ number);
        };
        biConsumer.accept(10,"reda");

    }
}