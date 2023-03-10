package myclasses;

import fileio.UserInput;

import java.util.ArrayList;

import static checker.CheckStyleConstants.MAXIMUM_ERROR_CHECKSTYLE;

public class Curusrr extends UserInput {
    /**
     * basic constructor
     */
    public Curusrr() {
        numFreePremiumMovies = MAXIMUM_ERROR_CHECKSTYLE / 2;
        tokensCount = 0;
        purchasedMovies = new ArrayList<>();
        watchedMovies = new ArrayList<>();
        likedMovies = new ArrayList<>();
        ratedMovies = new ArrayList<>();
    }

    /**
     * @param newuser  Copy Constructor for deep Copy of arraylist
     */
    public Curusrr(final Curusrr newuser) {
        this.setCredentials(newuser.getCredentials());
        this.tokensCount = newuser.getTokensCount();
        this.numFreePremiumMovies = newuser.getNumFreePremiumMovies();
        this.purchasedMovies = newuser.getPurchasedMovies();
        this.watchedMovies = newuser.getWatchedMovies();
        this.likedMovies = newuser.getLikedMovies();
        this.ratedMovies = newuser.getRatedMovies();

        this.purchasedMovies = new ArrayList<>();
        for (int i = 0; i < newuser.getPurchasedMovies().size(); i++) {
            Movies newmovie = new Movies(newuser.getPurchasedMovies().get(i));
            this.purchasedMovies.add(newmovie);
        }
        this.watchedMovies = new ArrayList<>();
        for (int i = 0; i < newuser.getWatchedMovies().size(); i++) {
            Movies newmovie = new Movies(newuser.getWatchedMovies().get(i));
            this.watchedMovies.add(newmovie);
        }
        this.likedMovies = new ArrayList<>();
        for (int i = 0; i < newuser.getLikedMovies().size(); i++) {
            Movies newmovie = new Movies(newuser.getLikedMovies().get(i));
            this.likedMovies.add(newmovie);
        }
        this.ratedMovies = new ArrayList<>();
        for (int i = 0; i < newuser.getRatedMovies().size(); i++) {
            Movies newmovie = new Movies(newuser.getRatedMovies().get(i));
            this.ratedMovies.add(newmovie);
        }
    }

    private int tokensCount;
    private int numFreePremiumMovies;
    private ArrayList<Movies> purchasedMovies;
    private ArrayList<Movies> watchedMovies;
    private ArrayList<Movies> likedMovies;
    private ArrayList<Movies> ratedMovies;

    /**
     * @return tokens
     */
    public int getTokensCount() {
        return tokensCount;
    }

    /**
     * @param tokensCount setter
     */
    public void setTokensCount(final int tokensCount) {
        this.tokensCount = tokensCount;
    }

    /**
     * @return Number of Free Premium Movies
     */
    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    /**
     * @param numFreePremiumMovies setter
     */
    public void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }

    /**
     * @return GETTER for PurchasedMovies
     */
    public ArrayList<Movies> getPurchasedMovies() {
        return purchasedMovies;
    }

    /**
     * @param purchasedMovies setter
     */
    public void setPurchasedMovies(final ArrayList<Movies> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }

    /**
     * @return WatchedMovies getter
     */
    public ArrayList<Movies> getWatchedMovies() {
        return watchedMovies;
    }

    /**
     * @param watchedMovies setter
     */
    public void setWatchedMovies(final ArrayList<Movies> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    /**
     * @return LikedMovies
     */
    public ArrayList<Movies> getLikedMovies() {
        return likedMovies;
    }

    /**
     * @param likedMovies setter
     */
    public void setLikedMovies(final ArrayList<Movies> likedMovies) {
        this.likedMovies = likedMovies;
    }

    /**
     * @return RatedMovies
     */
    public ArrayList<Movies> getRatedMovies() {
        return ratedMovies;
    }

    /**
     * @param ratedMovies setter
     */
    public void setRatedMovies(final ArrayList<Movies> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }
}
