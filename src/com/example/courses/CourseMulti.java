package com.example.courses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Modified Course that can have multiple instructors and multiple textbooks.
 */
public class CourseMulti {
    private String courseName;
    private final List<Instructor> instructors = new ArrayList<>();
    private final List<Textbook> textbooks = new ArrayList<>();

    public CourseMulti(String courseName) {
        setCourseName(courseName);
    }

    // Getters
    public String getCourseName() { return courseName; }
    public List<Instructor> getInstructors() { return Collections.unmodifiableList(instructors); }
    public List<Textbook> getTextbooks() { return Collections.unmodifiableList(textbooks); }

    // Setters / mutators
    public void setCourseName(String courseName) {
        if (courseName == null || courseName.isBlank())
            throw new IllegalArgumentException("courseName cannot be blank");
        this.courseName = courseName;
    }
    public void addInstructor(Instructor instructor) {
        if (instructor == null) throw new IllegalArgumentException("instructor cannot be null");
        instructors.add(instructor);
    }
    public void addTextbook(Textbook textbook) {
        if (textbook == null) throw new IllegalArgumentException("textbook cannot be null");
        textbooks.add(textbook);
    }

    /** Prints course name, all instructors, and all textbooks. */
    public void print() {
        System.out.println("Course: " + courseName);

        System.out.print("Instructors: ");
        if (instructors.isEmpty()) {
            System.out.println("(none)");
        } else {
            for (int i = 0; i < instructors.size(); i++) {
                Instructor ins = instructors.get(i);
                System.out.print(ins.getFirstName() + " " + ins.getLastName());
                if (i < instructors.size() - 1) System.out.print("; ");
            }
            System.out.println();
        }

        System.out.print("Textbooks: ");
        if (textbooks.isEmpty()) {
            System.out.println("(none)");
        } else {
            for (int i = 0; i < textbooks.size(); i++) {
                Textbook tb = textbooks.get(i);
                System.out.print("\"" + tb.getTitle() + "\" by " + tb.getAuthor());
                if (i < textbooks.size() - 1) System.out.print("; ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
