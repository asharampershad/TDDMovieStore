package za.co.asha.model;

public class Movie {
    private String title;
    private String director;
    private int releaseYear;


    public Movie(String title, String director, int releaseYear) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public String title() {
        return title;
    }

    public String director() {
        return director;
    }

    public int releaseYear() {
        return releaseYear;
    }
}
