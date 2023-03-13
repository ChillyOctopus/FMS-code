import Handlers.*;
import com.sun.net.httpserver.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Random;

import static java.util.Random.*;

public class Server {

    private static final int MAX_CONNECTIONS = 12;
    private HttpServer server;

    private void run(String portNumber) throws IOException {
        System.out.println("Initializing HTTP Server on port "+portNumber);
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
        server.createContext("/clear", new ClearHandler());
        server.createContext("/fill", new FillHandler());
        server.createContext("/load", new LoadHandler());
        server.createContext("/person", new PersonHandler());
        server.createContext("/event", new EventHandler());
        server.createContext("/", new FileHandler());


        System.out.println("Starting server");
        server.start();
        // Log message indicating that the server has successfully started.
        System.out.println("Server started");
    }

    public static void main(String[] args) {
        //String portNumber = args[0];
        Random random = new Random();
        int portCreate =  random.nextInt(50000);
        portCreate+=10000;
        String portNumber = String.valueOf(portCreate);
        try{
            new Server().run(portNumber);

        }catch(IOException ex){
            System.out.println(ex.getMessage());
            System.out.println("Couldn't start server.");
        }
    }

}
