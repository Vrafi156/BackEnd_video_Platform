package fileio;


public final class ActionInput {
    private String type;
    private String page;
    private String feature;

    private String startsWith;
    private User credentials;

    private String movie;
    private int count;
    private Filterul filters;
    private int rate;

    public int getRate() {
        return rate;
    }

    public void setRate(final int rate) {
        this.rate = rate;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(final String movie) {
        this.movie = movie;
    }

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }


    public Filterul getFilters() {
        return filters;
    }

    public void setFilters(final Filterul filters) {
        this.filters = filters;
    }

    public User getCredentials() {
        return credentials;
    }

    public void setCredentials(final User credentials) {
        this.credentials = credentials;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getPage() {
        return page;
    }

    public void setPage(final String page) {
        this.page = page;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(final String feature) {
        this.feature = feature;
    }

    public String getStartsWith() {
        return startsWith;
    }

    public void setStartsWith(final String startsWith) {
        this.startsWith = startsWith;
    }


}
