package Handlers;

import Responses.ClearResponse;
import Services.Clear;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

public class ClearHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        boolean success = false;
        Gson gson = new Gson();

        try {
            if (exchange.getRequestMethod().equalsIgnoreCase("post")) {

                Clear clear = new Clear();
                ClearResponse response = clear.clear();

                String body = gson.toJson(response);

                OutputStream resBody = exchange.getResponseBody();

                exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
                writeString(body,resBody);
                exchange.getResponseBody().close();
                success = true;

            }

            if (!success) {
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
                ClearResponse response = new ClearResponse("Error: Bad Request.", false);
                String body = gson.toJson(response);
                writeString(body,exchange.getResponseBody());
                exchange.getResponseBody().close();
            }

        } catch (IOException ex) {
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
            ClearResponse response = new ClearResponse("Error: "+ex.getMessage(), false);
            String body = gson.toJson(response);
            writeString(body,exchange.getResponseBody());
            exchange.getRequestBody().close();
            ex.printStackTrace();

        }
    }

    private static void writeString(String str, OutputStream os) throws IOException {
        OutputStreamWriter sw = new OutputStreamWriter(os);
        sw.write(str);
        sw.flush();
    }
}
