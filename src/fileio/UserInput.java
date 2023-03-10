package fileio;


public class UserInput {
    private User credentials;

    /**
     * @return getter for credentials
     */
    public User getCredentials() {
        return credentials;
    }

    /**
     * @param credentials setter
     */
    public void setCredentials(final User credentials) {
        this.credentials = credentials;
    }

    /**
     * @return toString method
     */
    @Override
    public String toString() {
        return "userInput{"
                + "credentials="
                + credentials
                + '}';
    }
}
