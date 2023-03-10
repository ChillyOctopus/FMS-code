package Handlers;

import Requests.RegisterRequest;
import Responses.RegisterResponse;
import Services.Register;
import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.awt.font.TextHitInfo;
import java.io.*;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            //Ensure that it is the right method.
            if (exchange.getRequestMethod().equalsIgnoreCase("get")) {

                String urlPath = exchange.getRequestURI().getPath();
                System.out.println(urlPath);
                String dir = "web";
                File f;

                //return index.html case
                if(urlPath.equals("/") || urlPath == null){
                    f = new File(dir + "/index.html");
                } else {
                    f = new File(dir + urlPath);
                }

                //return 404 issue case
                if(!f.exists()){
                    f = new File(dir + "/HTML/404.html");
                    exchange.sendResponseHeaders(404,0);
                } else {
                    exchange.sendResponseHeaders(200,0);
                }

                OutputStream os = exchange.getResponseBody();
                Files.copy(f.toPath(),os);
                os.close();


            //sent post instead of get or something like that.
            } else {
                exchange.sendResponseHeaders(405,0);
                exchange.getResponseBody().close();
            }

        //Internal server error
        } catch (IOException ex) {
            exchange.sendResponseHeaders(500,0);
            exchange.getResponseBody().close();
            System.out.println("Exception");
        }
    }
}
