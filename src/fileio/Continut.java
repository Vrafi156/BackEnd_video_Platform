package fileio;

import java.util.ArrayList;

public final class Continut {
    private ArrayList<String> actors;
    private ArrayList<String> genre;

    public ArrayList<String> getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return "continut{"
                +
                "actors="
                + actors
                +
                ", genre="
                + genre
                +
                '}';
    }

    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(final ArrayList<String> genre) {
        this.genre = genre;
    }
}
