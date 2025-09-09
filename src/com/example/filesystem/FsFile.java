package com.example.filesystem;

/** Simple file (owned by a Folder). */
public class FsFile {
    private String name; // e.g., "index.html", "system.css"

    public FsFile(String name) {
        setName(name);
    }

    // Getter / Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("file name cannot be blank");
        this.name = name;
    }

    /** Print this file's name with a tree prefix & connector. */
    void print(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + name);
    }
}
