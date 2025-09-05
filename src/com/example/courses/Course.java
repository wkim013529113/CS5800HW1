package com.example.courses;

/**
 * Course HAS-A Instructor and HAS-A Textbook (single each).
 */
public class Course {
    private String courseName;
    private Instructor instructor; // aggregation
    private Textbook textbook;     // aggregation

    public Course(String courseName, Instructor instructor, Textbook textbook) {
        setCourseName(courseName);
        setInstructor(instructor);
        setTextbook(textbook);
    }

    // Getters
    public String getCourseName() { return courseName; }
    public Instructor getInstructor() { return instructor; }
    public Textbook getTextbook() { return textbook; }

    // Setters
    public void setCourseName(String courseName) {
        if (courseName == null || courseName.isBlank())
            throw new IllegalArgumentException("courseName cannot be blank");
        this.courseName = courseName;
    }
    public void setInstructor(Instructor instructor) {
        if (instructor == null)
            throw new IllegalArgumentException("instructor cannot be null");
        this.instructor = instructor;
    }
    public void setTextbook(Textbook textbook) {
        if (textbook == null)
            throw new IllegalArgumentException("textbook cannot be null");
        this.textbook = textbook;
    }

    /** Prints course name, instructor first+last, and textbook title+author. */
    public void print() {
        System.out.println("Course: " + courseName);
        System.out.println("Instructor: " + instructor.getFirstName() + " " + instructor.getLastName());
        System.out.println("Textbook: " + textbook.getTitle() + " by " + textbook.getAuthor());
        System.out.println();
    }
}
