package pages;

import myclasses.Curusrr;
import myclasses.Movies;
import myclasses.Output;
import myclasses.Dates;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.UserInput;

import java.util.ArrayList;
import java.util.HashMap;

public final class Page {
    private HashMap<String, ArrayList<String>> kids;

    private HashMap<String, ArrayList<String>> functions;


    public HashMap<String, ArrayList<String>> getKids() {
        return kids;
    }

    public void setKids(final HashMap<String, ArrayList<String>> kids) {
        this.kids = kids;
    }

    public HashMap<String, ArrayList<String>> getFunctions() {
        return functions;
    }

    public void setFunctions(final HashMap<String, ArrayList<String>> functions) {
        this.functions = functions;
    }

    public Page() {
    }

    /**
     * @param users Register function
     * @param curr
     * @return
     */
    public int Register(final ArrayList<Curusrr> users, final UserInput curr) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getCredentials().getName().equals(curr.getCredentials().getName())
                    && users.get(i).getCredentials().
                    getPassword().equals(curr.getCredentials().getName())) {
                return 1;
            }
        }
        return 0;


    }

    /**
     * @param users login check function
     * @param username
     * @param password
     * @return
     */
    public int Login(final ArrayList<Curusrr> users, final String username, final String password) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getCredentials().getName().equals(username)
                    && users.get(i).getCredentials().getPassword().equals(password)) {
                return i;
            }
        }
        return -1;

    }


    /**
     * @param data watch a movie method
     * @param movie
     * @param ERR
     * @param output
     */
    public void watch(final Dates data, final String movie,
                      final Output ERR, final ArrayNode output) {
        int ok = -1;
        for (int i = 0; i < data.getCurrentUser().getPurchasedMovies().size(); i++) {
            if (data.getCurrentUser().getPurchasedMovies().get(i).getName().equals(movie)) {
                ok = i;
                break;
            }
        }

        if (ok != -1) {
            ArrayList<Movies> afisaremovies = new ArrayList<>();
            for (int j = 0; j < data.getCurrentMoviesList().size(); j++) {
                afisaremovies.add(new Movies(data.getCurrentMoviesList().get(j)));
            }

            data.getCurrentUser().getWatchedMovies().
                    add((data.getCurrentUser().getPurchasedMovies().get(ok)));
            Curusrr afisare = new Curusrr(data.getCurrentUser());
            Output err_show = new Output();
            err_show.setCurrentUser(afisare);
            err_show.setCurrentMoviesList(afisaremovies);
            err_show.setError(null);
            output.addPOJO(err_show);

        } else {
            output.addPOJO(ERR);
        }
    }

    /**
     * @param data Purchase a Movie Method
     * @param movie
     * @param ERR
     * @param output
     */
    public void purchase(final Dates data, final String movie,
                         final Output ERR, final ArrayNode output) {
        int ok = -1;
        for (int i = 0; i < data.getCurrentMoviesList().size(); i++) {
            if (data.getCurrentMoviesList().get(i).getName().equals(movie)) {
                ok = i;
                break;
            }
        }
        for (int i = 0; i < data.getCurrentUser().getPurchasedMovies().size(); i++) {
            if (data.getCurrentUser().getPurchasedMovies().get(i).getName().equals(movie)) {
                ok = i;
                break;
            }
        }


        if (ok != -1) {
            if (data.getCurrentUser().getCredentials().getAccountType().equals("premium")) {
                if (data.getCurrentUser().getNumFreePremiumMovies() > 0) {
                    data.getCurrentUser().
                            setNumFreePremiumMovies(data.
                                    getCurrentUser().getNumFreePremiumMovies() - 1);
                } else {
                    data.getCurrentUser().setTokensCount(data.
                            getCurrentUser().getTokensCount() - 2);
                }
            } else {
                data.getCurrentUser().setTokensCount(data.getCurrentUser().getTokensCount() - 2);
            }
            ArrayList<Movies> afisaremovies = new ArrayList<>();
            for (int j = 0; j < data.getCurrentMoviesList().size(); j++) {
                afisaremovies.add(new Movies(data.getCurrentMoviesList().get(j)));
            }

            data.getCurrentUser().getPurchasedMovies().add((data.getCurrentMoviesList().get(ok)));
            Curusrr afisare = new Curusrr(data.getCurrentUser());
            Output err_show = new Output();
            err_show.setCurrentUser(afisare);
            err_show.setCurrentMoviesList(afisaremovies);
            err_show.setError(null);
            output.addPOJO(err_show);
        } else {
            output.addPOJO(ERR);
        }

    }

    /**
     * @param data Like a movie method
     * @param movie
     * @param ERR
     * @param output
     */
    public void like(final Dates data, final String movie,
                     final Output ERR, final ArrayNode output) {
        int ok = -1;
        for (int i = 0; i < data.getCurrentUser().getWatchedMovies().size(); i++) {
            if (data.getCurrentUser().getWatchedMovies().get(i).getName().equals(movie)) {
                ok = i;
                break;
            }
        }
        if (ok != -1) {

            data.getCurrentUser().getLikedMovies().
                    add(data.getCurrentUser().getWatchedMovies().get(ok));
            data.getCurrentUser().getLikedMovies().
                    get(ok).setNumLikes(data.getCurrentUser().getLikedMovies().get(ok).getNumLikes() + 1);
            ArrayList<Movies> afisaremovies = new ArrayList<>();
            for (int j = 0; j < data.getCurrentMoviesList().size(); j++) {
                afisaremovies.add(new Movies(data.getCurrentMoviesList().get(j)));
            }

            Curusrr afisare = new Curusrr(data.getCurrentUser());
            Output err_show = new Output();
            err_show.setCurrentUser(afisare);
            err_show.setCurrentMoviesList(afisaremovies);
            err_show.setError(null);
            output.addPOJO(err_show);
        } else {
            output.addPOJO(ERR);
        }
    }

    /**
     * @param data rate a movie method
     * @param movie
     * @param ERR
     * @param output
     * @param rate
     */
    public void rate(final Dates data, final String movie, final Output ERR, final ArrayNode output, final int rate) {
        int ok = -1;
        for (int i = 0; i < data.getCurrentUser().getWatchedMovies().size(); i++) {
            if (data.getCurrentUser().getWatchedMovies().get(i).getName().equals(movie)) {
                ok = i;
                break;
            }
        }
        if (ok != -1 && rate <= (2 + 2 + 1)) {
            data.getCurrentUser().getWatchedMovies().get(ok).
                    setRating(data.getCurrentUser().getWatchedMovies().get(ok).getRating() + rate);
            data.getCurrentUser().getRatedMovies().add(data.getCurrentUser().getWatchedMovies().get(ok));
            ArrayList<Movies> afisaremovies = new ArrayList<>();
            data.getCurrentUser().getWatchedMovies().get(ok).setNumRatings(data.getCurrentUser().
                    getWatchedMovies().get(ok).getNumRatings() + 1);
            for (int j = 0; j < data.getCurrentMoviesList().size(); j++) {
                afisaremovies.add(new Movies(data.getCurrentMoviesList().get(j)));
            }

            Curusrr afisare = new Curusrr(data.getCurrentUser());
            Output err_show = new Output();
            err_show.setCurrentUser(afisare);
            err_show.setCurrentMoviesList(afisaremovies);
            err_show.setError(null);
            output.addPOJO(err_show);
        } else {
            output.addPOJO(ERR);
        }

    }
}
