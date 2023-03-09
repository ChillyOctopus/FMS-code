import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServerTest {
    HttpClient hc;

    @BeforeEach
    public void setup(){
       hc = HttpClient.newHttpClient();
    }

    @Test
    public void userReg(){
        String postReq =
                "\"username\":\"susan\"," +
                "\"password\":\"mysecret\"," +
                "\"email\":\"susan@gmail.com\"," +
                "\"firstName\":\"Susan\"," +
                "\"lastName\":\"Ellis\"," +
                "\"gender\":\"f";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/user/register"))
                .POST(HttpRequest.BodyPublishers.ofString(postReq))
                .build();

        hc.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}
