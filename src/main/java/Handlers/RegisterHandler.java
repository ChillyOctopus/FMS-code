package Handlers;

import Requests.RegisterRequest;
import Services.Register;
import Responses.RegisterResponse;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.*;
import com.google.gson.*;

import java.io.IOException;
import java.net.HttpURLConnection;

public class RegisterHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        boolean success = false;
        String body = null;
        try {
            //Ensure that it is the right method.
            if (exchange.getRequestMethod().equalsIgnoreCase("post")) {

                //Get the request headers
                Headers reqHeaders = exchange.getRequestHeaders();
                //Get the request body
                InputStream reqBody = exchange.getRequestBody();
                //Read the contents of the body
                String reqBodyContents = readString(reqBody);
                //Print them out.
                System.out.println("Contents of request: " + reqBodyContents);

                //Make a gson object
                Gson gson = new Gson();
                //Translate reqBodyContents into our object.
                RegisterRequest request = gson.fromJson(reqBodyContents, RegisterRequest.class);

                //Make a service object
                Register service = new Register();
                //Call service, which returns a new response object.
                RegisterResponse response = service.register(request);


                // Send the HTTP response back, starting with status code and any headers.
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
                // Close the response body output stream, indicating that the response is complete.

                //translate response object into string
                body = gson.toJson(response);
                //Open output stream for response body
                OutputStream resBody = exchange.getResponseBody();
                //put into response body
                resBody.write(body.getBytes());
                //close the output stream
                resBody.close();
                success = true;

            }
            if (!success) {
                // The HTTP request was invalid, return a "bad request"
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
                // Close the response body output stream.
                exchange.getResponseBody().close();
            }

        } catch (IOException ex) {
            //It is our fault, so we send an internal error
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR,0);
            exchange.getRequestBody().close();
            ex.printStackTrace();
            System.out.println("Issue in Register Handler...\n");
            System.out.println("Body: " + body);
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
