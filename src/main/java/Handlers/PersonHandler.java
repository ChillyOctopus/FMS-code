package Handlers;

import Requests.GetAllRequest;
import Requests.SinglePersonRequest;
import Responses.AllPersonResponse;
import Responses.SinglePersonResponse;
import Services.GetAllPersons;
import Services.SinglePerson;
import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

public class PersonHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        boolean success = false;
        try{
            if(exchange.getRequestMethod().equalsIgnoreCase("get")){
                Headers headers = exchange.getRequestHeaders();
                if(headers.containsKey("Authtoken")){

                    String path = exchange.getRequestURI().getPath();
                    String[] pathComponents = path.split("/");
                    if(pathComponents.length > 1 && pathComponents.length < 4){

                        String token = headers.getFirst("Authtoken");
                        String responseBody;
                        Gson gson = new Gson();

                        if(pathComponents.length == 2){
                            //Return a list of all persons related to user related to token
                            GetAllRequest request = new GetAllRequest(token);
                            GetAllPersons service = new GetAllPersons();
                            AllPersonResponse response = service.findAll(request);
                            responseBody = gson.toJson(response);
                        }else{
                            //Return the single person who is related to user related to token based on ID
                            SinglePersonRequest request = new SinglePersonRequest(token,pathComponents[2]);
                            SinglePerson service = new SinglePerson();
                            SinglePersonResponse response = service.find(request);
                            responseBody = gson.toJson(response);
                        }

                        OutputStream os = exchange.getResponseBody();
                        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK,0);
                        writeString(responseBody,os);
                        os.close();
                        success = true;

                    }
                }
            }

            if(!success){
                //Is not "GET" request
                //or Doesn't have authtoken header
                //or Wrong number of parameters or slashes
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST,0);
                exchange.getRequestBody().close();
            }

        } catch(IOException ex){
            //Internal error.
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR,0);
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
