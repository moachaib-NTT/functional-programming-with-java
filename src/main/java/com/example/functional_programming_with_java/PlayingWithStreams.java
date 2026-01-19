package com.example.functional_programming_with_java;

import org.springframework.boot.SpringApplication;

import java.util.List;

public class PlayingWithStreams {
    public static void main(String[] args) {
        SpringApplication.run(FunctionalProgrammingWithJavaApplication.class, args);

        List<Integer> numbers = List.of(12,5,7,9,6,5,4);
        int sum = addListFunctional(numbers);
        System.out.println("sum --> "+ sum);
    }



    private static Integer sum(Integer integer, Integer integer1) {
        return integer+integer1;
    }
    private static int addListFunctional(List<Integer> numbers) {
        return numbers.stream()
//                .reduce(0,PlayingWithStreams::sum);
//                .reduce(0,(x,y)-> x+y); //with Lambda expression
                .reduce(0, Integer::sum); // with method reference
    }



    /*----Jshell Examples ---- https://tryjshell.org/      */

// --------------------   Max value
//      numbers.stream().reduce(0,(x,y)->x>y ? x:y)

// --------------------   Min value
//    numbers.stream().reduce(Integer.MAX_VALUE,(x,y)->x>y?y:x)


// --------------------   Square every number in list and find the sum of squares
//      numbers.stream().map(w->w*w).reduce(0,Integer::sum)

// --------------------   cube  every number in list and find the sum of cubes
//      numbers.stream().map(w->w*w*w).reduce(0,Integer::sum)

// --------------------   Find Sum of odd numbers in the list
//    numbers.stream().filter(x->x%2==0).reduce(0,Integer::sum)

// --------------------   Remove Duplicate
//     numbers.stream().distinct().forEach(System.out::println)

// --------------------   Sort
//      numbers.stream().sorted().forEach(System.out::println)

// --------------------   Sort + comparator natural order
//      strings.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println)

// --------------------   Sort + comparator reverse order
//     strings.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println)
// --------------------   Sort + comparator custom order
//      strings.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println)


}
