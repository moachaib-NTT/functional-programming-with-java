package com.example.functional_programming_with_java;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course{
        private String name;
        private String category;
        private int reviewScore;
        private int noOfStudents;


public String getCategory() {
    return category;
}

public void setCategory(String category) {
    this.category = category;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public int getReviewScore() {
    return reviewScore;
}

public void setReviewScore(int reviewScore) {
    this.reviewScore = reviewScore;
}

public int getNoOfStudents() {
    return noOfStudents;
}

public void setNoOfStudents(int noOfStudents) {
    this.noOfStudents = noOfStudents;
}




    @Override
    public String toString() {
        return "Cours{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                ", noOfStudents=" + noOfStudents +
                '}';
    }

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }
}


public class CustomClass {
    public static void main(String[] args) {

        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        // allMatch , noneMatch , anyMatch
        Predicate<Course> reviewScoreGreaterThan95 = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGreaterThan90 = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLessThan90 = course -> course.getReviewScore() < 90;

        System.out.println("Creater than 95 -> "+courses.stream().allMatch(reviewScoreGreaterThan95));
        System.out.println("Creater than 90 -> "+courses.stream().allMatch(reviewScoreGreaterThan90));
        System.out.println("Less than 90 -> "+courses.stream().noneMatch(reviewScoreLessThan90));
        System.out.println("Any Match Greater than 95 -> "+courses.stream().anyMatch(reviewScoreGreaterThan95));


    //  sorted / comparing / thenComparing / reversed
        Comparator<Course> comparingByNoOfStudents = Comparator.comparing(Course::getNoOfStudents);
        System.out.println( "Sorted by No of students -> "+
                courses.stream().sorted(comparingByNoOfStudents).collect(Collectors.toList())
        );

        Comparator<Course> comparingByNoOfStudentsReversed = Comparator.comparing(Course::getNoOfStudents).reversed();
        System.out.println( "Sorted by No of students reversed -> "+
                courses.stream().sorted(comparingByNoOfStudentsReversed).collect(Collectors.toList())
        );

        Comparator<Course> comparingByNoOfStudentsAndNumberOfRiviews = Comparator.comparing(Course::getNoOfStudents)
                                                                                .thenComparing(Course::getReviewScore)
                                                                                .reversed();
        System.out.println( "Sorted by No of students and Rivews -> "+
                courses.stream().sorted(comparingByNoOfStudentsAndNumberOfRiviews).collect(Collectors.toList())
        );


// limit() / skip()
        System.out.println( "Sorted by No of students and Rivews with limit 5 -> "+
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNumberOfRiviews)
                        .limit(5)
                        .collect(Collectors.toList())
        );

        System.out.println( "Sorted by No of students and Rivews with skip 3 -> "+
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNumberOfRiviews)
                        .skip(3)
                        .collect(Collectors.toList())
        );
        
// takeWhile() / dropWhile()
        System.out.println( "takeWhile review score greater than 95 -> "+
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNumberOfRiviews)
                        .takeWhile(course -> course.getReviewScore() > 95)
                        .collect(Collectors.toList())
        );

        System.out.println( "dropWhile review score greater than 95 -> "+
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNumberOfRiviews)
                        .dropWhile(course -> course.getReviewScore() > 95)
                        .collect(Collectors.toList())
        );


// Max / Min
        System.out.println( "Max by review score -> "+
                courses.stream()
                        .max(comparingByNoOfStudentsAndNumberOfRiviews)
        );

        System.out.println( "Min by review score -> "+
                courses.stream()
                        .min(comparingByNoOfStudentsAndNumberOfRiviews)
        );
// filter / min / orElse
        System.out.println( "Min by review score with filter -> "+
                courses.stream()
                        .filter(reviewScoreLessThan90)
                        .min(comparingByNoOfStudentsAndNumberOfRiviews)
                        .orElse(new Course("Kubernetes", "Cloud", 91, 20000))
        );

        // filter / min /  --> without orElse <--
        System.out.println( "Min by review score with filter -> "+
                courses.stream()
                        .filter(reviewScoreLessThan90)
                        .min(comparingByNoOfStudentsAndNumberOfRiviews)
        );
        //return optional.empty;



    // findFirst  / findAny-(is non deterministic operation
        System.out.println( "findFirst -> "+
                courses.stream()
                        .filter(reviewScoreGreaterThan95)
                        .sorted(comparingByNoOfStudentsAndNumberOfRiviews)
                        .findFirst()
        );

        System.out.println( "findAny -> "+
                courses.stream()
                        .filter(reviewScoreGreaterThan95)
                        .sorted(comparingByNoOfStudentsAndNumberOfRiviews)
                        .findAny()  // non deterministic
        );
//sum / average / count
        System.out.println( "Sum of no of students -> "+
                courses.stream()
                        .filter(reviewScoreGreaterThan95)
                        .mapToInt(Course::getNoOfStudents)
                        .sum()
        );

        System.out.println( "Average of no of students -> "+
                courses.stream()
                        .filter(reviewScoreGreaterThan95)
                        .mapToInt(Course::getNoOfStudents)
                        .average()
        );

        System.out.println( "Count of no of students -> "+
                courses.stream()
                        .filter(reviewScoreGreaterThan95)
                        .mapToInt(Course::getNoOfStudents)
                        .count()
        );
// GroupingBy
        System.out.println( "Grouping by category -> "+
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory))
        );

        System.out.println( "Grouping by category and counting -> "+
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,Collectors.counting()))
        );

        System.out.println( "Grouping by category and max review score -> "+
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.maxBy(
                                        comparingByNoOfStudentsAndNumberOfRiviews
                                )))
        );

// groupingBy and mapping
        System.out.println( "Grouping by category and mapping -> "+
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(
                                        Course::getName,
                                        Collectors.toList()
                                )))
        );

    }

}
