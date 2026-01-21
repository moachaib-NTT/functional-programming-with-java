package com.example.functional_programming_with_java;

import org.springframework.boot.SpringApplication;

import java.util.List;

public class MethodesReferencesPratiques {

    private static void print(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        SpringApplication.run(FunctionalProgrammingWithJavaApplication.class, args);

        List<String> courses = List.of("Java", "Python", "JavaScript", "C++", "Ruby","Spring Boot" ,"Spring Framework");


        courses.stream()
                .map(str -> str.toUpperCase())
                .forEach(str -> System.out.println(str)); // Lambda expression


        courses.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println); // Method reference

        courses.stream()
                .map(String::toUpperCase)
                .forEach(MethodesReferencesPratiques::print); // Method reference

    }
}
