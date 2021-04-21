package za.co.asha;

import org.junit.Before;
import org.junit.Test;
import za.co.asha.model.Movie;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class MovieStoreTest {
    private final MovieStore movieStore = new MovieStore();
    private final Movie harryPotter = new Movie("Harry Potter", "Rowling", 2000);
    private final Movie starWars = new Movie("STAR Wars", "Shwimmer", 1999);
    private final Movie starTrek = new Movie("STAR Trek", "Shwimmer", 2002);
    private final Movie shawshank = new Movie("Shawshank Redemption", "Bob", 2001);
    private final Movie takeThat = new Movie("Take That", "Shwimmer", 2010);

    @Before
    public void setUp() throws Exception {
        movieStore.add(harryPotter);
        movieStore.add(starTrek);
        movieStore.add(starWars);
        movieStore.add(shawshank);
        movieStore.add(takeThat);
    }

    @Test
    public void returnsNoResultsWhenNoTitlesPartiallyMatchSearch() throws Exception {
        MovieStore movieStore = new MovieStore();
        List<Movie> results = movieStore.findByPartialTitle("abc");

        assertThat(results.size(), is(0));
    }

    @Test
    public void findAMovieWhenTitleIsPartiallyMatched() throws Exception {
        List<Movie> results = movieStore.findByPartialTitle("arry");

        assertThat(results.size(), is(1));
        assertThat(results, contains(harryPotter));
    }



    @Test
    public void findsMoviesWhenTitlesArePartiallyMatchedCaseInsensitive() throws Exception {
        List<Movie> results = movieStore.findByPartialTitle("TAR");

        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(starTrek, starWars));
    }

    @Test
    public void findsMoviesWhenDirectorExactlyMatches() throws Exception {
        List<Movie> results = movieStore.findByDirector("Shwimmer");

        assertThat(results.size(), is(3));
        assertThat(results, containsInAnyOrder(starTrek, starWars, takeThat));
    }

    @Test
    public void findsMoviesWhenReleaseYearIsBetweenTwoValues() throws Exception {
        List<Movie> results = movieStore.findByReleaseYear(1999, 2002);

        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(harryPotter, shawshank));
    }
}