package com.example.courses;

/** Driver for the multi-instructor + multi-textbook version. */
public class CourseDriverMulti {
    public static void main(String[] args) {
        // Instructors (make up the second one)
        Instructor nima  = new Instructor("Nima",  "Davarpanah", "3-2636");
        Instructor alice = new Instructor("Alice", "Johnson",    "4-1122");

        // Textbooks (second one made up)
        Textbook cleanCode   = new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall");
        Textbook refactoring = new Textbook("Refactoring", "Martin Fowler", "Addison-Wesley");

        CourseMulti ase = new CourseMulti("Advanced Software Engineering");
        ase.addInstructor(nima);
        ase.addInstructor(alice);
        ase.addTextbook(cleanCode);
        ase.addTextbook(refactoring);

        ase.print();
    }
}
