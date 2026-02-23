package http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HTTP {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(8080), 0); //bind server to the port
        server.createContext("/hello", new HelloHandler()); //created an endpoint: bind a command with URL
        server.start();
        System.out.println("The program is listening 8080 port");
        // we can do GET http://localhost:8080/hello
    }
}

class HelloHandler implements HttpHandler { //we must handle each endpoint
    String responseMessage = "Here is a message!";

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        httpExchange.sendResponseHeaders(200, 0); //send status code and length

        try (OutputStream os = httpExchange.getResponseBody()) { //use ByteStream Writer
            os.write(responseMessage.getBytes());
        }
    }
}
