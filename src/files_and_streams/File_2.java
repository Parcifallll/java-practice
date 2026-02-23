package files_and_streams;

import java.nio.file.Path;
import java.nio.file.Paths; //class only for cast: URI -> Path, String -> Path
import java.nio.file.Files;

public class File_2 {
    public static void main(String[] args) {
        Path dir = Paths.get("C:\\Users\\89307\\IdeaProjects\\Practice");
        System.out.println(Files.exists(dir));
    }
}
