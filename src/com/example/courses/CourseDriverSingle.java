package com.example.courses;

/**
 * Driver for single-instructor + single-textbook version.
 * Example data: Instructor Nima Davarpanah office 3-2636, textbook "Clean Code"
 */
public class CourseDriverSingle {
    public static void main(String[] args) {
        Instructor nima = new Instructor("Nima", "Davarpanah", "3-2636");
        Textbook cleanCode = new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall");

        Course ase = new Course("Advanced Software Engineering", nima, cleanCode);
        ase.print();
    }
}
