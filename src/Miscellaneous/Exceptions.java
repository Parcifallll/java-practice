package Miscellaneous;

import java.io.File;
import java.io.FileNotFoundException;

public class Exceptions {
    public static void main(String[] args) {
        try {
            Error.print2();
        } catch (ArithmeticException e) {
            for (StackTraceElement stack : e.getStackTrace()) {
                System.out.println(String.format("%s.%s(%s:%s)", stack.getClassName(), stack.getMethodName(), stack.getFileName(), stack.getLineNumber()));
            }
        }
        Error.print2();

        try {
            Throws.throwsTest(); //surround with try-catch block
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Error {
    public static void print() {
        System.out.println(10 / 0);
    }

    public static void print2() {
        print();
    }
}


class Throws {
    public static void throwsTest() throws FileNotFoundException { //unchecked exception must be declared in the method signature
        File file = new File("file.txt");
        if (!file.exists())
            throw new FileNotFoundException("File not found.");
    }
}