package Models;

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
    private static String tokenChars = "01234567890~!@#$%^&><AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

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
     * Generates a random string
     * @return returns randomized string
     */
    public static String generateAuthtoken(){
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        int count = random.nextInt(9);
        count += 8;

        for(int i = 0; i < count; i++){
            result.append(tokenChars.charAt(random.nextInt(tokenChars.length())));
        }

        System.out.print(result.toString());
        return result.toString();
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
}
