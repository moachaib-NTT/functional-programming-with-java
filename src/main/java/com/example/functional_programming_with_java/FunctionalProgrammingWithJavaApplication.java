package com.example.functional_programming_with_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FunctionalProgrammingWithJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionalProgrammingWithJavaApplication.class, args);


		printAllNumbersinListFunctional(List.of(12,9,8,7,6,5,4,3,2,1));
	}

	public static void print(int number){
		System.out.println(number);
	}

	private static void printAllNumbersinListFunctional(List<Integer> numbers) {

		numbers.stream()
				.forEach(FunctionalProgrammingWithJavaApplication ::print); // Methode Reference


	}


}
