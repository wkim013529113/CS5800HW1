package com.example.courses;

/** Represents a textbook. */
public class Textbook {
    private String title;
    private String author;
    private String publisher;

    public Textbook(String title, String author, String publisher) {
        setTitle(title);
        setAuthor(author);
        setPublisher(publisher);
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }

    // Setters (with basic validation)
    public void setTitle(String title) {
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("title cannot be blank");
        this.title = title;
    }
    public void setAuthor(String author) {
        if (author == null || author.isBlank())
            throw new IllegalArgumentException("author cannot be blank");
        this.author = author;
    }
    public void setPublisher(String publisher) {
        if (publisher == null || publisher.isBlank())
            throw new IllegalArgumentException("publisher cannot be blank");
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (" + publisher + ")";
    }
}
