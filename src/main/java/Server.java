import com.sun.net.httpserver.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;

public class Server {

    Server(){
        try {
            HttpServer server = HttpServer.create();
            server.bind(new InetSocketAddress(8080),0);
            server.start();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
            System.out.println("Couldn't create server.\n");
        }
    }

    public static void main(String[] args) {
        Server s = new Server();
    }


}
