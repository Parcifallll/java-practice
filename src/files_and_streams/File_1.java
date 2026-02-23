package files_and_streams;

import java.io.File;

public class File_1 {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\89307\\IdeaProjects\\Practice");
        System.out.println(dir.isFile()); //this is a directory
        System.out.println(dir.isDirectory() + "\n"); //true
        for (File file : dir.listFiles()) { //returns File-objects, dir.list() returns Strings
            if (file.isFile()) System.out.println(file.getName());
        }
    }

}
