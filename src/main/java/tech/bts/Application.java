package tech.bts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.bts.Model.Movie;
import tech.bts.Service.MovieService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner createDummyData(MovieService movieService) {

        return args -> {

            movieService.addMovie(new Movie("Saw",103.0, true));
            movieService.addMovie(new Movie("Frozen", 102.0, false));
            movieService.getAllMovies();

        };
    }
}
