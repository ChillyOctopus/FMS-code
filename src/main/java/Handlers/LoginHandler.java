package Handlers;

import Requests.LoginRequest;

import Services.Login;
import Responses.LoginResponse;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class LoginHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try{
            boolean success = false;
            String body;
            if(exchange.getRequestMethod().equalsIgnoreCase("post")){

                Gson gson = new Gson();
                InputStream reqBody = exchange.getRequestBody();
                String reqBodyData = readString(reqBody);
                LoginRequest request = gson.fromJson(reqBodyData,LoginRequest.class);

                Login service = new Login();
                LoginResponse response = service.login(request);

                exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK,0);
                OutputStream os = exchange.getResponseBody();
                body = gson.toJson(response);
                os.write(body.getBytes());
                os.close();
                success = true;
            }

            if(!success){
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST,0);
                exchange.getResponseBody().close();
            }

        } catch(IOException ex){
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR,0);
            exchange.getResponseBody().close();
            ex.printStackTrace();
            ex.getMessage();
        }
    }

    /*
The readString method shows how to read a String from an InputStream.
*/
    private String readString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStreamReader sr = new InputStreamReader(is);
        char[] buf = new char[1024];
        int len;
        while ((len = sr.read(buf)) > 0) {
            sb.append(buf, 0, len);
        }
        return sb.toString();
    }
}
