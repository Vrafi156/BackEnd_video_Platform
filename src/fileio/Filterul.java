package fileio;

public final class Filterul {
    private Sorting sort;
    private Continut contains;

    public Sorting getSort() {
        return sort;
    }

    public void setSort(final Sorting sort) {
        this.sort = sort;
    }

    public Continut getContains() {
        return contains;
    }

    public void setContains(final Continut contains) {
        this.contains = contains;
    }

    @Override
    public String toString() {
        return "filterul{"
                +
                "sort="
                + sort
                +
                ", contains="
                + contains
                +
                '}';
    }
}
