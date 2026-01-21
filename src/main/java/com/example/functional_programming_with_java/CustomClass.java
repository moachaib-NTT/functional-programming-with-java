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




    }

}
