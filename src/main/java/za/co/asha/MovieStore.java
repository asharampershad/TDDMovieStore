package za.co.asha;

import za.co.asha.model.Movie;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class MovieStore {
    List<Movie> movies = new LinkedList<Movie>();

    public List<Movie> findByPartialTitle(String partialTitle) {
        return findBy(movie -> movie.title().contains(partialTitle));
    }

    public List<Movie> findByDirector(String director) {
        return findBy(movie -> movie.director().equals(director));
    }

    public List<Movie> findByReleaseYear(int from, int to) {
        return findBy(movie -> movie.releaseYear() > from && movie.releaseYear() < to);
    }

    interface Predicate {
        boolean matches (Movie movie);
    }

    private List<Movie> findBy(Predicate predicate) {
        List<Movie> result = new LinkedList<>();
        for (Movie movie : movies) {
            if (predicate.matches(movie)) {
                result.add(movie);
            }
        }
        return result;
    }


    public void add(Movie movie) {
        movies.add(movie);
    }
}
