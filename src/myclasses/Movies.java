package myclasses;

import fileio.MoviesInput;

public class Movies extends MoviesInput {
    private int numLikes;
    private double rating;
    private int numRatings;

    public Movies(final MoviesInput a) {
        this.setName(a.getName());
        this.setActors(a.getActors());
        this.setDuration(a.getDuration());
        this.setYear(a.getYear());
        this.setGenres(a.getGenres());
        this.setCountriesBanned(a.getCountriesBanned());
        numLikes = 0;
        rating = 0.00;
        numRatings = 0;
    }

    public Movies(final Movies a) {
        this.setName(a.getName());
        this.setActors(a.getActors());
        this.setDuration(a.getDuration());
        this.setYear(a.getYear());
        this.setGenres(a.getGenres());
        this.setCountriesBanned(a.getCountriesBanned());
        numLikes = a.getNumLikes();
        rating = a.getRating();
        numRatings = a.getNumRatings();
    }


    /**
     * @return Number of likes
     */
    public int getNumLikes() {
        return numLikes;
    }

    /**
     * @param numLikes setter
     */
    public void setNumLikes(final int numLikes) {
        this.numLikes = numLikes;
    }

    /**
     * @return rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * @param rating setter
     */
    public void setRating(final double rating) {
        this.rating = rating;
    }

    /**
     * @return NumRatiingS
     */
    public int getNumRatings() {
        return numRatings;
    }

    /**
     * @param numRatings setter
     */
    public void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }
}
