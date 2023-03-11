package Handlers;

import Requests.FillRequest;
import Services.Fill;
import Responses.FillResponse;


import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

import static java.lang.Integer.parseInt;

public class FillHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        boolean success = false;
        String body;
        Gson gson = new Gson();

        try {
            if (exchange.getRequestMethod().equalsIgnoreCase("post")) {

                String path = exchange.getRequestURI().getPath();
                /*
                Splits into '' + 'fill' + 'whateverElse' + 'whatever...' ect.
                The first one is EMPTY because it takes in the backslash.
                 */

                String[] components = path.split("/", -1);

                if (components.length > 2 && components.length < 5) {

                    int generations;
                    if (components.length == 3) {
                        //Then we just have the first three parts of the path.
                        generations = 4;
                    } else {
                        //Get the fourth part of the path /fill/jennifer/5, would be 5
                        generations = parseInt(components[3]);
                    }


                    FillRequest request = new FillRequest(components[2], generations);
                    Fill service = new Fill();
                    FillResponse response = service.fill(request);
                    body = gson.toJson(response);

                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
                    OutputStream os = exchange.getResponseBody();
                    writeString(body, os);
                    os.close();
                    success = true;
                }
            }

            if(!success){
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST,0);
                String error = "Wrong number of parameters or type of request.";
                FillResponse response = new FillResponse(error,false);
                writeString(gson.toJson(response),exchange.getResponseBody());
                exchange.getResponseBody().close();
            }

            } catch(IOException ex){
                //It is our fault, so we send an internal error
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
                String error = "Internal Server error";
                FillResponse response = new FillResponse(error,false);
                writeString(gson.toJson(response),exchange.getResponseBody());
                exchange.getResponseBody().close();
                ex.printStackTrace();
            }
        }

    private static void writeString(String str, OutputStream os) throws IOException {
        OutputStreamWriter sw = new OutputStreamWriter(os);
        sw.write(str);
        sw.flush();
    }
}