package fileio;

import java.util.ArrayList;

public final class Input {
    private ArrayList<UserInput> users;
    private ArrayList<MoviesInput> movies;
    private ArrayList<ActionInput> actions;


    public void setUsers(final ArrayList<UserInput> users) {
        this.users = users;
    }

    public ArrayList<MoviesInput> getMovies() {
        return movies;
    }

    public void setMovies(final ArrayList<MoviesInput> movies) {
        this.movies = movies;
    }

    public ArrayList<ActionInput> getActions() {
        return actions;
    }

    public void setActions(final ArrayList<ActionInput> actions) {
        this.actions = actions;
    }

    public ArrayList<UserInput> getUsers() {
        return users;
    }
}
