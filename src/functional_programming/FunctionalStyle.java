package functional_programming;

import java.util.List;
import java.util.ArrayList;

//The purpose of this approach is to deliver methods as params (objects)
public class FunctionalStyle {
    public static void main(String[] args) {
        //StringSaverConfig lowerCaseConfig = new LowerCaseStringSaver(); //create config objects for various config types (1 way)
        StringSaverConfig upperCaseConfig = new UpperCaseStringSaver();

        StringSaverConfig lowerCaseConfig = new StringSaverConfig() { //Anonymous class (2 way) - class LowerCaseStringSaver is redundant
            @Override
            public String transform(String string) {
                return string.toLowerCase();
            }
        };

        StringSaver lowerCaseSaver = new StringSaver(lowerCaseConfig); //create functional_programming.StringSaver objects with different realizations
        StringSaver upperCaseSaver = new StringSaver(upperCaseConfig);

    }
}

interface StringSaverConfig {
    String transform(String string);
}


class LowerCaseStringSaver implements StringSaverConfig { //concrete config implementation (one realization of the all possible)
    @Override
    public String transform(String string) {
        return string.toLowerCase();
    }
}

class UpperCaseStringSaver implements StringSaverConfig { //another realization
    @Override
    public String transform(String string) {
        return string.toUpperCase();
    }
}

class StringSaver { //saver class
    private List<String> list = new ArrayList<>();
    private String string;
    private StringSaverConfig config; //declared interface, not a specific realization!

    public StringSaver(StringSaverConfig config) {
        this.config = config;
    }

    public void save(String string) {
        list.add(config.transform(string));
    }

}