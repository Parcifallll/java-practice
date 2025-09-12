package HTTP;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HTTP_Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        URI uri = URI.create("https://httpstatuses.com/500");

        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder(); // create builder
        HttpRequest request = requestBuilder
                .GET()
                .uri(uri)
                .version(HttpClient.Version.HTTP_1_1)
                .header("Accept", "application/html")
                .build(); //build a request

        /*HttpClient client = HttpClient.newBuilder() // custom settings
                .connectTimeout(Duration.ofSeconds(5)) // max waiting-for-response time
                .build(); //build a client */
        HttpClient client = HttpClient.newHttpClient(); //default settings


        // BodyHandler (converted to string)

         // send request and get a response

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }
        catch (IOException | InterruptedException e) {
            System.out.println("Wrong URL.");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Not a URL");
        }

    }
}
