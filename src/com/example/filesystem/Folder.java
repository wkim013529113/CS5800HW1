package com.example.filesystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Folder owns subfolders and files (composition).
 * Deleting a folder deletes everything inside it.
 */
public class Folder {
    private String name;
    private final List<Folder> subfolders = new ArrayList<>();
    private final List<FsFile> files = new ArrayList<>();

    public Folder(String name) { setName(name); }

    // Getters (read-only views for safety)
    public String getName() { return name; }
    public List<Folder> getSubfolders() { return Collections.unmodifiableList(subfolders); }
    public List<FsFile> getFiles() { return Collections.unmodifiableList(files); }

    // Setter
    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("folder name cannot be blank");
        this.name = name;
    }

    // Mutators
    public Folder addFolder(Folder child) {
        if (child == null) throw new IllegalArgumentException("child folder cannot be null");
        subfolders.add(child);
        return this;
    }

    public Folder addFile(FsFile file) {
        if (file == null) throw new IllegalArgumentException("file cannot be null");
        files.add(file);
        return this;
    }

    /** Remove a direct child folder by exact name (cascades). */
    public boolean removeSubfolderByName(String name) {
        for (int i = 0; i < subfolders.size(); i++) {
            Folder f = subfolders.get(i);
            if (f.getName().equals(name)) {
                f.deleteAll();        // cascade deletion
                subfolders.remove(i); // remove reference
                return true;
            }
        }
        return false;
    }

    /** Remove a direct child file by exact name. */
    public boolean removeFileByName(String name) {
        return files.removeIf(f -> f.getName().equals(name));
    }

    /** Cascade delete all contained folders and files. */
    public void deleteAll() {
        for (Folder f : subfolders) f.deleteAll();
        subfolders.clear();
        files.clear();
    }

    // ---------- Printing (ASCII tree) ----------
    public void printTree() {
        System.out.println(getName() + "/");
        printChildren("", true);
    }

    private void printChildren(String prefix, boolean isRoot) {
        int total = subfolders.size() + files.size();
        int idx = 0;

        // Print subfolders first (like the screenshot)
        for (Folder child : subfolders) {
            boolean isLast = (++idx == total);
            System.out.println(prefix + (isLast ? "└── " : "├── ") + child.getName() + "/");
            String nextPrefix = prefix + (isLast ? "    " : "│   ");
            child.printChildren(nextPrefix, false);
        }

        // Then files
        for (FsFile file : files) {
            boolean isLast = (++idx == total);
            file.print(prefix, isLast);
        }
    }
}
