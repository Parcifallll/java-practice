package HTTP;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class JsonResponse {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        URI url = URI.create("https://ipwhois.app/json/46.226.227.20?lang=ru");
        HttpRequest request = HttpRequest.newBuilder().uri(url).GET().build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                JsonElement jsonElement = JsonParser.parseString(response.body());
                if (jsonElement.isJsonObject()) {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    if (jsonObject.has("country") && jsonObject.has("city")) { //check if these fields are returned
                        System.out.println("Country: " + jsonObject.get("country").getAsString() + " city: " + jsonObject.get("city").getAsString());
                    }
                } else {
                    JsonArray jsonArray = jsonElement.getAsJsonArray(); //if the server returns smth odd
                    for (JsonElement ob : jsonArray) {
                        System.out.println(ob.toString());
                    }
                }

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
