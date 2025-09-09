package FilesAndStreams;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.Reader;
import java.io.FileReader;


public class Streams {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\89307\\Desktop\\Test.txt";
        Writer writer = new FileWriter(path, true); //if file already exists - write next to the text
        Writer writer_2 = new FileWriter(path); //always rewrite the text
        writer.write("1\n");
        writer.write("2\n");
        writer.write("3\n");
        writer.close();

        Reader reader = new FileReader(path);
        int file = reader.read();
        while (file != -1){
            System.out.println((char) file);
            file = reader.read();
        }
        reader.close();
    }
}
