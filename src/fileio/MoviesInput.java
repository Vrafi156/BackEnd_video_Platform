package fileio;

import java.util.ArrayList;

public class MoviesInput {

    private String name;
     private int year;
     private int duration;
     private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;


    /**
     * @return toString Method
     */
    @Override
    public String toString() {
        return "moviesInput{"
                +
                "name='"
                + name
                + '\''
                +
                ", year="
                + year
                +
                ", duration="
                + duration
                +
                ", genres="
                + genres
                +
                ", actors="
                + actors
                +
                ", countriesBanned="
                + countriesBanned
                +
                '}';
    }

    /**
     * @return getter for actors
     */
    public ArrayList<String> getActors() {
        return actors;
    }

    /**
     * @param actors seeter
     */
    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    /**
     * @return getter for banned Countries
     */
    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    /**
     * @param countriesBanned setter for banned Countries
     */
    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    /**
     * @return getter for name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name setter
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return getter for year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year setter
     */
    public void setYear(final int year) {
        this.year = year;
    }

    /**
     * @return getter for Duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration setter
     */
    public void setDuration(final int duration) {
        this.duration = duration;
    }

    /**
     * @return getter for Genres
     */
    public ArrayList<String> getGenres() {
        return genres;
    }

    /**
     * @param genres setter
     */
    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }


}
