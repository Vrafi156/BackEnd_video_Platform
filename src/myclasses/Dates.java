package myclasses;

import pages.Page;

import java.util.ArrayList;

public class Dates {
    private String currentPage;
    private ArrayList<Page> pages;
    private Curusrr currentUser;
    private static Dates single_instance = null;
    private Dates() {
        currentPage = new String();
        pages = new ArrayList<>();
        currentUser = new Curusrr();
    }
    public static Dates getInstance()
    {
        if (single_instance == null)
            single_instance = new Dates();

        return single_instance;
    }
    private ArrayList<Movies> currentMoviesList;

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
     * @return CurrentPage
     */
    public String getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage setter
     */
    public void setCurrentPage(final String currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return  pages
     */
    public ArrayList<Page> getPages() {
        return pages;
    }

    /**
     * @param pages setter
     */
    public void setPages(final ArrayList<Page> pages) {
        this.pages = pages;
    }

    /**
     * @return CurrentUser
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
