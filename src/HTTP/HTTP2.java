package HTTP;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;

public class HTTP2 {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(8080), 0);
        server.createContext("/", new MyHandler());
        server.start();


    }
}

class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod(); // get method
        System.out.println("Request method: " + requestMethod);

        String response = "";
        if (requestMethod.equals("POST")) {
            InputStream body = exchange.getRequestBody(); // get body
            BufferedReader reader = new BufferedReader(new InputStreamReader(body));
            StringBuilder requestBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }

            Gson gson = new Gson();
            Person p1 = gson.fromJson(requestBody.toString(), Person.class); //deserialization
            response = "Hello, " + p1.name + "!";
        }

        exchange.sendResponseHeaders(200, response.getBytes().length); // send response
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}