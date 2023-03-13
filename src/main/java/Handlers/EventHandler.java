package Handlers;

import Requests.GetAllRequest;
import Requests.SingleEventRequest;
import Services.GetAllEvents;
import Services.SingleEvent;
import Responses.AllEventResponse;
import Responses.SingleEventResponse;

import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

public class EventHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        boolean success = false;
        try{
            if(exchange.getRequestMethod().equalsIgnoreCase("get")){
                Headers headers = exchange.getRequestHeaders();
                if(headers.containsKey("Authorization")){
                    System.out.println("Headers have key Authorization.");
                    String path = exchange.getRequestURI().getPath();
                    String[] pathComponents = path.split("/");
                    for(String s : pathComponents){
                        System.out.println(s);
                    }
                    if(pathComponents.length > 1 && pathComponents.length < 4){
                        System.out.println("Components between 1 and 4.");
                        String token = headers.getFirst("Authorization");
                        System.out.println("Token: "+token);
                        String responseBody;
                        Gson gson = new Gson();

                        if(pathComponents.length == 2){
                            System.out.println("2 Components");
                            //Return a list of all persons related to user related to token
                            GetAllRequest request = new GetAllRequest(token);
                            GetAllEvents service = new GetAllEvents();
                            System.out.println("Created req and ser objects, about to enter implementation.");
                            AllEventResponse response = service.findAll(request);
                            System.out.println("Worked?: "+response.success);
                            responseBody = gson.toJson(response);
                        }else{
                            System.out.println("3 Components");
                            //Return the single event who is related to user related to token based on ID
                            SingleEventRequest request = new SingleEventRequest(token,pathComponents[2]);
                            SingleEvent service = new SingleEvent();
                            SingleEventResponse response = service.find(request);
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
