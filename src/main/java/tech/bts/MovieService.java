package tech.bts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie) {
        movieRepository.addMovie(movie);
        return movie;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public Movie getMovieByTitle(String title) {
        return this.movieRepository.getMovieByTitle(title);
    }
}
