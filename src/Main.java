import myclasses.Curusrr;
import myclasses.Movies;
import myclasses.Output;
import myclasses.Dates;
import pages.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static checker.CheckStyleConstants.MAXIMUM_ERROR_CHECKSTYLE;

public class Main {
    /**
     * @param args Main function
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode output = objectMapper.createArrayNode();
        String pathin = args[0];
        String pathout = args[1];
        Input inputData;
        inputData = objectMapper.readValue(new File(pathin), Input.class);
        HashMap<String, ArrayList<String>> kids = new HashMap<String, ArrayList<String>>();
        ArrayList<String> kidz = new ArrayList<String>();
        kidz.add("login");
        kidz.add("register");
        kids.put("HomeNeauth", kidz);

        ArrayList<String> kidz1 = new ArrayList<String>();

        kidz1.add("movies");
        kidz1.add("logout");
        kidz1.add("upgrades");
        kids.put("Homeauth", kidz1);

        ArrayList<String> kidz2 = new ArrayList<String>();
        kidz2.add("Homeauth");
        kidz2.add("see details");
        kidz2.add("logout");
        kidz2.add("movies");
        kids.put("movies", kidz2);

        ArrayList<String> kidz3 = new ArrayList<String>();

        kidz3.add("Homeauth");
        kidz3.add("movies");
        kidz3.add("logout");
        kids.put("upgrades", kidz3);

        ArrayList<String> kidz4 = new ArrayList<String>();
        kids.put("logout", kidz4);
        kids.put("login", kidz4);
        kids.put("register", kidz4);

        ArrayList<String> kidz5 = new ArrayList<String>();
        kidz5.add("Homeauth");
        kidz5.add("movies");
        kidz5.add("upgrades");
        kidz5.add("logout");
        kids.put("see details", kidz5);

        HashMap<String, ArrayList<String>> functions = new HashMap<String, ArrayList<String>>();
        ArrayList<String> func = new ArrayList<String>();
        func.add("login");
        functions.put("login", func);

        ArrayList<String> func1 = new ArrayList<String>();
        func1.add("register");
        functions.put("register", func1);

        ArrayList<String> func2 = new ArrayList<String>();

        func2.add("search");
        func2.add("filter");
        functions.put("movies", func2);

        ArrayList<String> func3 = new ArrayList<String>();
        func3.add("buy premium account");
        func3.add("buy tokens");
        functions.put("upgrades", func3);

        ArrayList<String> func4 = new ArrayList<String>();
        func4.add("purchase");
        func4.add("watch");
        func4.add("like");
        func4.add("rate");
        functions.put("see details", func4);

        ArrayList<String> func5 = new ArrayList<String>();

        functions.put("logout", func5);
        functions.put("HomeNeauth", func5);
        functions.put("Homeauth", func5);

        //setings the hashmaps
        Page pagina = new Page();
        pagina.setKids(kids);
        pagina.setFunctions(functions);

        String type, page;
        int oklog = 0, ok;

        ArrayList<UserInput> informations = new ArrayList<>();
        Dates data = Dates.getInstance();
        data.setCurrentMoviesList(new ArrayList<>());
        //0
        UserInput test = new UserInput();

        data.setCurrentPage("HomeNeauth");
        Output ERR = new Output();
        ERR.setError("Error");
        ERR.setCurrentMoviesList(new ArrayList<Movies>());
        Output ERRval = new Output();
        ERRval.setCurrentMoviesList(new ArrayList<Movies>());

        String feature;
        String password;
        String username;
        String seeDET;

        ArrayList<Movies> filmebune = new ArrayList<>();

        for (int j = 0; j < inputData.getMovies().size(); j++) {
            filmebune.add(new Movies(inputData.getMovies().get(j)));
        }


        ArrayList<Curusrr> bazadedate = new ArrayList<>();
        for (int i = 0; i < inputData.getUsers().size(); i++) {
            bazadedate.add(new Curusrr());
            bazadedate.get(i).setCredentials(inputData.getUsers().get(i).getCredentials());
        }
        String movieCurent = new String();
        for (int i = 0; i < inputData.getActions().size(); i++) {
            type = inputData.getActions().get(i).getType();
            if (type.equals("change page")) {
                page = inputData.getActions().get(i).getPage();
                if (pagina.getKids().get(data.getCurrentPage()).contains(page)) {
                    data.setCurrentPage(page);
                    if (data.getCurrentPage().equals("logout")) {
                        data.setCurrentPage("HomeNeauth");
                        data.setCurrentUser(null);
                        data.getCurrentMoviesList().removeAll(data.getCurrentMoviesList());

                    }
                    if (data.getCurrentPage().equals("movies")) {
                        ArrayList<Movies> filme = new ArrayList<>();

                        for (int j = 0; j < filmebune.size(); j++) {
                            if (!filmebune.get(j).getCountriesBanned().
                                    contains(data.getCurrentUser().getCredentials().getCountry())) {
                                filme.add(filmebune.get(j));
                            }
                        }
                        ArrayList<Movies> afisaremovies = new ArrayList<>();
                        for (int j = 0; j < filme.size(); j++) {
                            afisaremovies.add(new Movies(filme.get(j)));
                        }
                        Curusrr afisareUser = new Curusrr(data.getCurrentUser());
                        User afisareCred = new User(data.getCurrentUser().getCredentials());
                        afisareUser.setCredentials(afisareCred);
                        ERRval.setCurrentUser(afisareUser);
                        data.setCurrentMoviesList(filme);
                        ERRval.setCurrentMoviesList(new ArrayList<Movies>());
                        ERRval.setCurrentMoviesList(afisaremovies);
                        Output afisare = new Output(ERRval);
                        output.addPOJO(afisare);


                    }
                    if (data.getCurrentPage().equals("see details")) {
                        seeDET = inputData.getActions().get(i).getMovie();
                        movieCurent = seeDET;
                        ok = 0;
                        ArrayList<Movies> filme = new ArrayList<>();
                        for (int j = 0; j < data.getCurrentMoviesList().size(); j++) {
                            if (data.getCurrentMoviesList().get(j).getName().contains(seeDET)
                                    && !data.getCurrentMoviesList().get(j).getCountriesBanned().
                                    contains(data.getCurrentUser().getCredentials().getCountry())) {
                                filme.add((data.getCurrentMoviesList().get(j)));
                                ok = 1;
                                break;
                            }
                        }


                        if (ok == 1) {


                            data.setCurrentMoviesList(new ArrayList<>());
                            data.setCurrentMoviesList(filme);

                            ArrayList<Movies> afisaremovies = new ArrayList<>();
                            for (int j = 0; j < filme.size(); j++) {
                                afisaremovies.add(new Movies(filme.get(j)));
                            }

                            ERRval.setCurrentMoviesList(new ArrayList<Movies>());
                            ERRval.setCurrentMoviesList(afisaremovies);
                            Curusrr afisareUser = new Curusrr(data.getCurrentUser());
                            User afisareCred = new User(data.getCurrentUser().getCredentials());
                            afisareUser.setCredentials(afisareCred);
                            ERRval.setCurrentUser(afisareUser);

                            Output afisare = new Output(ERRval);
                            output.addPOJO(afisare);
                        } else {

                            data.setCurrentPage("movies");
                            output.addPOJO(ERR);
                        }

                    }
                } else {
                    output.addPOJO(ERR);
                }
            }
            if (type.equals("on page")) {
                feature = inputData.getActions().get(i).getFeature();
                if (pagina.getFunctions().get(data.getCurrentPage()).contains(feature)) {
                    if (feature.equals("login")) {
                        password = inputData.getActions().get(i).getCredentials().getPassword();
                        username = inputData.getActions().get(i).getCredentials().getName();
                        oklog = 0;
                        oklog = pagina.Login(bazadedate, username, password);

                        if (oklog != -1) {

                            data.setCurrentUser(new Curusrr());
                            data.getCurrentUser().
                                    setCredentials(bazadedate.get(oklog).getCredentials());
                            data.setCurrentMoviesList(new ArrayList<>());
                            Curusrr afisareUser = new Curusrr(data.getCurrentUser());
                            User afisareCred = new User(data.getCurrentUser().getCredentials());
                            afisareUser.setCredentials(afisareCred);
                            ERRval.setCurrentUser(afisareUser);
                            ERRval.setCurrentMoviesList(data.getCurrentMoviesList());
                            Output afisare = new Output(ERRval);
                            output.addPOJO(afisare);
                            data.setCurrentPage("Homeauth");

                        } else {
                            data.setCurrentPage("HomeNeauth");
                            output.addPOJO(ERR);
                        }
                    }
                    if (feature.equals("register")) {
                        ok = 0;
                        UserInput adding = new UserInput();
                        adding.setCredentials(inputData.getActions().get(i).getCredentials());
                        //FIX REGISTER
                        ok = pagina.Register(bazadedate, adding);
                        if (ok == 1) {
                            output.addPOJO(ERR);
                            data.setCurrentPage("HomeNeauth");
                        } else {
                            bazadedate.add(new Curusrr());
                            bazadedate.get(bazadedate.size() - 1).
                                    setCredentials(inputData.getActions().get(i).getCredentials());

                            data.setCurrentUser(new Curusrr());
                            data.getCurrentUser().setCredentials(adding.getCredentials());


                            ERRval.setCurrentUser(new Curusrr());
                            Curusrr afisareUser = new Curusrr(data.getCurrentUser());
                            User afisareCred = new User(data.getCurrentUser().getCredentials());
                            afisareUser.setCredentials(afisareCred);
                            ERRval.setCurrentUser(afisareUser);
                            Output afisare = new Output(ERRval);
                            output.addPOJO(afisare);
                            data.setCurrentPage("Homeauth");
                        }
                    }
                    if (feature.equals("search")) {
                        String searched;
                        searched = inputData.getActions().get(i).getStartsWith();
                        ArrayList<Movies> filmeafisare = new ArrayList<>();
                        ArrayList<Movies> filme = new ArrayList<>();

                        for (int j = 0; j < filmebune.size(); j++) {
                            if (!filmebune.get(j).getCountriesBanned().
                                    contains(data.getCurrentUser().getCredentials().getCountry())) {
                                if (filmebune.get(j).getName().startsWith(searched)) {
                                    filme.add(filmebune.get(j));
                                    filmeafisare.add(new Movies(filmebune.get(j)));
                                }
                            }
                        }
                        data.setCurrentMoviesList(new ArrayList<>());
                        data.setCurrentMoviesList(filme);
                        ERRval.setCurrentMoviesList(new ArrayList<Movies>());
                        ERRval.setCurrentMoviesList(filmeafisare);
                        Output afisare = new Output(ERRval);
                        output.addPOJO(afisare);

                    }
                    if (feature.equals("filter")) {
                        ArrayList<Movies> filme = new ArrayList<>();
                        for (int j = 0; j < filmebune.size(); j++) {
                            if (!filmebune.get(j).getCountriesBanned().
                                    contains(data.getCurrentUser().getCredentials().getCountry())) {
                                filme.add((filmebune.get(j)));
                            }
                        }
                        Filterul filters = new Filterul();
                        if (inputData.getActions().get(i).getFilters().getSort() != null) {
                            filters.setSort(inputData.getActions().get(i).getFilters().getSort());
                            if (filters.getSort().getRating().equals("decreasing")) {
                                Collections.sort(filme, (o1, o2) -> {
                                    if (o1.getRating() > o2.getRating()) {
                                        return -1;
                                    } else {
                                        return 1;
                                    }
                                });
                            }
                            if (filters.getSort().getRating().equals("increasing")) {
                                Collections.sort(filme, (o1, o2) -> {
                                    if (o1.getRating() < o2.getRating()) {
                                        return -1;
                                    } else {
                                        return 1;
                                    }
                                });
                            }
                            if (filters.getSort().getDuration() != null) {

                                if (filters.getSort().getDuration().equals("decreasing")) {
                                    Collections.sort(filme, (o1, o2) -> {
                                        if (o1.getDuration() > o2.getDuration()) {
                                            return -1;
                                        } else {
                                            return 1;
                                        }
                                    });
                                }
                                if (filters.getSort().getDuration().equals("increasing")) {
                                    Collections.sort(filme, (o1, o2) -> {
                                        if (o1.getDuration() > o2.getDuration()) {
                                            return 1;
                                        } else {
                                            return -1;
                                        }
                                    });
                                }
                            }
                        }
                        if (inputData.getActions().get(i).
                                getFilters().getContains() != null) {
                            filters.setContains(inputData.getActions().
                                    get(i).getFilters().getContains());
                            int j = 0;
                            if (filters.getContains().getActors() != null) {
                                while (j < filme.size()) {
                                    if (!filme.get(j).getActors().
                                            containsAll(inputData.getActions().get(i)
                                                    .getFilters().getContains().getActors())) {
                                        filme.remove(j);
                                    } else {
                                        j++;
                                    }
                                }
                            }
                            j = 0;
                            if (filters.getContains().getGenre() != null) {
                                while (j < filme.size()) {
                                    if (!filme.get(j).getGenres().
                                            containsAll(inputData.getActions().
                                                    get(i).getFilters().getContains().getGenre())) {
                                        filme.remove(j);
                                    } else {
                                        j++;
                                    }
                                }
                            }
                        }
                        ArrayList<Movies> afisaremovies = new ArrayList<>();
                        for (int j = 0; j < filme.size(); j++) {
                            afisaremovies.add(new Movies(filme.get(j)));
                        }
                        data.setCurrentMoviesList(filme);
                        Curusrr afisareUser = new Curusrr(data.getCurrentUser());
                        User afisareCred = new User(data.getCurrentUser().getCredentials());
                        afisareUser.setCredentials(afisareCred);
                        ERRval.setCurrentUser(afisareUser);
                        ERRval.setCurrentMoviesList(new ArrayList<Movies>());
                        ERRval.setCurrentMoviesList(afisaremovies);
                        Output afisare = new Output(ERRval);
                        output.addPOJO(afisare);

                    }
                    if (feature.equals("buy premium account")) {
                        if (data.getCurrentUser().getTokensCount() > MAXIMUM_ERROR_CHECKSTYLE) {
                            data.getCurrentUser().
                                    setTokensCount(data.getCurrentUser().getTokensCount() - 10);
                            data.getCurrentUser().getCredentials().setAccountType("premium");

                        } else {
                            output.addPOJO(ERR);
                        }

                    }
                    if (feature.equals("buy tokens")) {
                        int count = inputData.getActions().get(i).getCount();
                        String setbalance;
                        int balance = Integer.parseInt(data.getCurrentUser().
                                getCredentials().getBalance());
                        if (count > balance) {
                            output.addPOJO(ERR);
                        } else {
                            balance -= count;
                            data.getCurrentUser().
                                    getCredentials().setBalance(Integer.toString(balance));
                            data.getCurrentUser().
                                    setTokensCount(data.getCurrentUser().getTokensCount() + count);
                        }
                    }
                    if (feature.equals("purchase")) {
                        ok = 0;
                        if (movieCurent != null) {
                            pagina.purchase(data, movieCurent, ERR, output);
                        } else {
                            output.addPOJO(ERR);
                        }
                    }
                    if (feature.equals("watch")) {
                        ok = 0;
                        if (movieCurent != null) {
                            pagina.watch(data, movieCurent, ERR, output);
                        } else {
                            output.addPOJO(ERR);
                        }
                    }
                    if (feature.equals("like")) {
                        ok = 0;
                        if (movieCurent != null) {
                            pagina.like(data, movieCurent, ERR, output);
                        } else {
                            output.addPOJO(ERR);
                        }
                    }
                    if (feature.equals("rate")) {
                        int rate;
                        rate = inputData.getActions().get(i).getRate();
                        if (movieCurent != null) {
                            pagina.rate(data, movieCurent, ERR, output, rate);
                        } else {
                            output.addPOJO(ERR);
                        }

                    }
                } else {
                    output.addPOJO(ERR);

                }
            }

        }


        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(pathout), output);
    }
}
