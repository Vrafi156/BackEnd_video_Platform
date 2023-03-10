package myclasses;


import java.util.ArrayList;

public final class Output {
    private String error;
    private ArrayList<Movies> currentMoviesList;
    private Curusrr currentUser;

    /**
     * @return toString method
     */
    @Override
    public String toString() {
        return "Output{"
                +
                "error='"
                + error
                + '\''
                +
                ", currentMoviesList="
                + currentMoviesList
                +
                ", currentUser="
                + currentUser
                +
                '}';
    }

    /**
     * @param a copyConstructor
     */
    public Output(final Output a) {
        this.setCurrentMoviesList(a.getCurrentMoviesList());
        this.setError(null);
        this.setCurrentUser(a.getCurrentUser());
    }

    /**
     * constructor
     */
    public Output() {
        this.setCurrentMoviesList(new ArrayList<Movies>());
        this.setError("error");
        this.setCurrentUser(null);
    }

    /**
     * @return getERROR
     */
    public String getError() {
        return error;
    }

    /**
     * @param error setter
     */
    public void setError(final String error) {
        this.error = error;
    }

    /**
     * @return CurrentMovieList
     */
    public ArrayList<Movies> getCurrentMoviesList() {
        return currentMoviesList;
    }

    /**
     * @param currentMoviesList setter
     */
    public void setCurrentMoviesList(final ArrayList<Movies> currentMoviesList) {
        this.currentMoviesList = currentMoviesList;
    }

    /**
     * @return Current user
     */
    public Curusrr getCurrentUser() {
        return currentUser;
    }

    /**
     * @param currentUser setter
     */
    public void setCurrentUser(final Curusrr currentUser) {
        this.currentUser = currentUser;
    }
}
