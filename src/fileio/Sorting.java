package fileio;

public final class Sorting {
    private String rating;
    private String duration;

    public String getRating() {
        return rating;
    }

    public void setRating(final String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "sorting{"
                +
                "rating='"
                + rating
                + '\''
                +
                ", duration='"
                + duration
                + '\''
                +
                '}';
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(final String duration) {
        this.duration = duration;
    }
}
