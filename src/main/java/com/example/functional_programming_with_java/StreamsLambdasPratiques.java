package com.example.functional_programming_with_java;

import org.springframework.boot.SpringApplication;

import java.util.List;

public class StreamsLambdasPratiques {
    public static void main(String[] args) {
        SpringApplication.run(FunctionalProgrammingWithJavaApplication.class, args);

//        printOddNumbersInRange(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
//        PrintStringsindividually(List.of("Streams", "Lambdas", "filters", "maps"));
//        PrintStringsContainsSpringWord(List.of("Spring Boot","Streams", "Lambdas", "filters", "maps","Spring"));
//        PrintStringsContainMoreThan4Word(List.of("Spring Boot","Streams", "SQL","Lambdas", "filters", "maps","Spring","JWT"));
//        printSquareEvenNumbersInRange(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
//        printCubesOfOddNumbersInRange(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        printLenghtOfStrings(List.of("Spring Boot","Streams", "SQL","Lambdas", "filters", "maps","Spring","JWT"));
    }



    private static void printOddNumbersInRange(List<Integer> integers) {
        integers.stream()
                .filter(number -> number%2 != 0)
                .forEach(System.out :: println);
    }


    private static void PrintStringsindividually(List<String> strgs) {

        strgs.stream()
                .forEach(System.out :: println);
    }

    //Using "contains()"
    private static void PrintStringsContainsSpringWord(List<String> strings) {
        strings.stream()
                .filter(string ->string.contains("Spring"))
                .forEach(System.out::println);
    }

    //Using "length()"
    private static void PrintStringsContainMoreThan4Word(List<String> strings) {
        strings.stream()
                .filter(string ->string.length() >= 4)
                .forEach(System.out::println);
    }

    // Using "map()"
    private static void printSquareEvenNumbersInRange(List<Integer> integers) {
        integers.stream()
                .filter(number -> number%2 == 0 )
                .map(number ->number*number)
                .forEach(System.out::println);
    }

    private static void printCubesOfOddNumbersInRange(List<Integer> integers) {
        
        integers.stream()
                .filter(integer -> integer%2 !=0)
                .map(integer -> integer*integer*integer)
                .forEach(System.out::println);
    }

    private static void printLenghtOfStrings(List<String> strings) {
        strings.stream()
                .map(string ->string + " : "+string.length())
                .forEach(System.out::println);
    }

}
