import Handlers.*;
import com.sun.net.httpserver.*;

import java.io.IOException;
import java.net.InetSocketAddress;



public class Server {

    private static final int MAX_CONNECTIONS = 12;
    private HttpServer server;

    private void run(String portNumber) throws IOException {
        System.out.println("Initializing HTTP Server");
        try {
            server = HttpServer.create(
                    new InetSocketAddress(Integer.parseInt(portNumber)),
                    MAX_CONNECTIONS);
        }
        catch (IOException e) {
            e.printStackTrace();
            return;
        }
        // Indicate that we are using the default "executor".
        // This line is necessary, but its function is unimportant for our purposes.
        server.setExecutor(null);
        System.out.println("Creating contexts");

        server.createContext("/user/register", new RegisterHandler());
        server.createContext("/user/login", new LoginHandler());
        server.createContext("/fill/<USERNAME>?/<GENERATIONS>?");
        server.createContext("/load");
        server.createContext("/person/<PERSONID>?");
        server.createContext("/person");
        server.createContext("/event/<EVENTID>?");
        server.createContext("/event");
        server.createContext("/", new FileHandler());



        //Default Handler
        //server.createContext("/", (HttpHandler) new FileHandler());

        System.out.println("Starting server");
        server.start();
        // Log message indicating that the server has successfully started.
        System.out.println("Server started");
    }

    public static void main(String[] args) {
        //String portNumber = args[0];
        String portNumber = "8080";
        try{
            new Server().run(portNumber);

        }catch(IOException ex){
            System.out.println(ex.getMessage());
            System.out.println("Couldn't start server.");
        }
    }

}
