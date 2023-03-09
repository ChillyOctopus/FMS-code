import Handlers.RegisterHandler;
import com.sun.net.httpserver.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.FileHandler;

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
