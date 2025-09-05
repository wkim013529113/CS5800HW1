package com.example.filesystem;

/**
 * Driver:
 * 1) Print php_demo1 and all subfolders/files.
 * 2) Delete folder "app" under "Source Files" and print again.
 * 3) Delete folder "public" under "Source Files" and print again.
 */
public class FileSystemDriver {
    public static void main(String[] args) {
        // Root folder: php_demo1
        Folder phpDemo1 = new Folder("php_demo1");

        // Source Files
        Folder sourceFiles = new Folder("Source Files");
        phpDemo1.addFolder(sourceFiles);

        // .phalcon
        sourceFiles.addFolder(new Folder(".phalcon"));

        // app with subfolders
        Folder app = new Folder("app");
        app.addFolder(new Folder("config"))
                .addFolder(new Folder("controllers"))
                .addFolder(new Folder("library"))
                .addFolder(new Folder("migrations"))
                .addFolder(new Folder("models"))
                .addFolder(new Folder("views"));
        sourceFiles.addFolder(app);

        // cache
        sourceFiles.addFolder(new Folder("cache"));

        // public with three files
        Folder pub = new Folder("public");
        pub.addFile(new FsFile(".htaccess"));
        pub.addFile(new FsFile(".htrouter.php"));
        pub.addFile(new FsFile("index.html"));
        sourceFiles.addFolder(pub);

        // -------- 1) Print full structure
        System.out.println("=== Initial structure ===");
        phpDemo1.printTree();

        // -------- 2) Delete folder "app" and print
        System.out.println("\n=== After deleting 'app' ===");
        sourceFiles.removeSubfolderByName("app");
        phpDemo1.printTree();

        // -------- 3) Delete folder "public" and print
        System.out.println("\n=== After deleting 'public' ===");
        sourceFiles.removeSubfolderByName("public");
        phpDemo1.printTree();
    }
}
