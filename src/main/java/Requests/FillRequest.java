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
}
