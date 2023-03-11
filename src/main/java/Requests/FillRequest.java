package Requests;

/**
 * Request body for Fill.
 */
public class FillRequest {
    /**
     * the username
     */
    private String username;
    /**
     * the generations requested
     */
    private int generations;

    /**
     * Constructor
     * @param username the username
     * @param generations the generations
     */
    public FillRequest(String username, int generations) {
        this.username = username;
        this.generations = generations;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getGenerations() {
        return generations;
    }

    public void setGenerations(int generations) {
        this.generations = generations;
    }
}
