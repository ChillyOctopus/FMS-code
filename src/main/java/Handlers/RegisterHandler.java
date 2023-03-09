package Handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.*;

import java.io.IOException;

public class RegisterHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        //Our response.
        String response = "Response here!\n";
        //The exchange object is sending back the status code (like 404 or 400 or 203) and the length of the response.
        httpExchange.sendResponseHeaders(200,response.getBytes().length);
        //The output stream is made equal to the OutputStream the httpExchange returns when getRespBod is called
        OutputStream os = httpExchange.getResponseBody();
        //Writes response
        os.write(response.getBytes());
        //MAKE SURE TO CLOSE!
        os.close();
    }
}
