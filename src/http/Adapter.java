package http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Adapter {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
        String json = gson.toJson(date); // implicitly create new TypeAdapter<LocalDate>
        System.out.println("Serialized data: " + json);

        LocalDate deserializedDate = gson.fromJson(json, LocalDate.class);
        System.out.println("Deserialized data: " + deserializedDate);




    }
}

class LocalDateAdapter extends TypeAdapter<LocalDate> {
    private static final DateTimeFormatter formatterWriter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter formatterReader = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @Override
    public void write(final JsonWriter jsonWriter, final LocalDate localDate) throws IOException { //serialization
        jsonWriter.value(localDate.format(formatterWriter));
    }

    @Override
    public LocalDate read(final JsonReader jsonReader) throws IOException { //deserialization
        return LocalDate.parse(jsonReader.nextString(), formatterReader);
    }

}