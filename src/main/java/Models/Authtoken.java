package Models;

import java.util.Objects;
import java.util.Random;

public class Authtoken {
    /**
     * the actual authtoken
     */
    private String authtoken;
    /**
     * associated username
     */
    private String username;
    /**
     * used for authtoken generation
     */
    private static final String TOKENCHARS = "01234567890AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

    /**
     * Constructor
     * @param authtoken the actual authtoken
     * @param username associated username
     */
    public Authtoken(String authtoken, String username) {
        this.authtoken = authtoken;
        this.username = username;
    }

    /**
     * Generates a random string for the authtoken
     * @return returns randomized string
     */
    public String generateAuthtoken(){
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        int count = random.nextInt(9);
        count += 12;

        for(int i = 0; i < count; i++){
            result.append(TOKENCHARS.charAt(random.nextInt(TOKENCHARS.length())));
        }

        String token = result.toString();
        System.out.print(token);
        this.authtoken = token;
        return token;
    }



    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authtoken authtoken1 = (Authtoken) o;
        return Objects.equals(authtoken, authtoken1.authtoken) && Objects.equals(username, authtoken1.username);
    }
}
