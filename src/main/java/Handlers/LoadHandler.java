package Handlers;

import Requests.LoadRequest;
import Services.Load;
import Responses.LoadResponse;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

public class LoadHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        boolean success = true;
        try{
            if(exchange.getRequestMethod().equalsIgnoreCase("post")){
                Gson gson = new Gson();
                String reqBody = exchange.getRequestBody().toString();
                LoadRequest request = gson.fromJson(reqBody,LoadRequest.class);

                Load service = new Load();
                LoadResponse response = service.load(request);

                String responseBody = gson.toJson(response);

                exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK,0);
                OutputStream os = exchange.getResponseBody();
                writeString(responseBody,os);
                os.close();


            }

            if(!success){
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST,0);
                exchange.getRequestBody().close();
            }

        } catch(IOException ex){
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR,0);
            exchange.getResponseBody().close();
        }
    }
    private static void writeString(String str, OutputStream os) throws IOException {
        OutputStreamWriter sw = new OutputStreamWriter(os);
        sw.write(str);
        sw.flush();
    }

}
