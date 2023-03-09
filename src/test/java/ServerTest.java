import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//NOTE: BE SURE TO HAVE THE SERVER RUNNING BEFORE YOU RUN THE TESTS
public class ServerTest {
    HttpClient hc;

    @BeforeEach
    public void setup(){
       hc = HttpClient.newHttpClient();
    }

    @Test
    public void userReg(){
        String postReq =
                "{"+
                "\"username\":\"susan\"," +
                "\"password\":\"mysecret\"," +
                "\"email\":\"susan@gmail.com\"," +
                "\"firstName\":\"Susan\"," +
                "\"lastName\":\"Ellis\"," +
                "\"gender\":\"f\""+
                "}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/user/register"))
                .POST(HttpRequest.BodyPublishers.ofString(postReq))
                .headers("Content-Type", "application/x-www-form-urlencoded")
                .build();

        hc.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}
