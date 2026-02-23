package files_and_streams;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Buffer {
    public static void main(String[] args) throws IOException { // always handle IOExceptions with java.io
        String file = "C:\\Users\\89307\\Desktop\\Test.txt";
        Path path = Paths.get(file);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.println("Text: " + br.readLine()); //Text: null
//            if (!Files.exists(path)) Files.createFile(path);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
