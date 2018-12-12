package tech.bts;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    private Map<String, Movie> movieMap;

    public MovieRepository() {
        this.movieMap = new HashMap<>();
    }

    public List<Movie> getAllMovies() {
        return new ArrayList<>(movieMap.values());
    }

    public Movie getMovieByTitle(String title) {
        return movieMap.get(title);
    }

    public void addMovie(Movie movie) {
        movieMap.put(movie.getTitle(), movie);
    }
}
