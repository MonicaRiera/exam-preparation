package tech.bts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/movies")
public class MovieWebController {

    private MovieService movieService;

    @Autowired
    public MovieWebController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getMovies() {
        String result = "<h1>Movies</h1><ul>";
        List<Movie> movies = this.movieService.getAllMovies();
        for (Movie movie : movies) {
            result += "<li><a href=\"/movies/" + movie.getTitle() + "\">" + movie.getTitle() +"</a>, " + movie.getLength() + " min, ";
            if (movie.isAdult()) {
                result += "for adults</li>";
            } else {
                result += "for all audiences</li>";
            }
        }

        result += "</ul><form action=\"/movies/add\" method=\"post\" modelAttribute=\"movie\">" +
                "Title: <input type=\"text\" name=\"title\">\n" +
                "Length: <input type=\"number\" name=\"length\">\n" +
                "For adults: <input type=\"checkbox\" name=\"adult\">\n" +
                "<button>Add movie</button></form>";
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{movieTitle}")
    public String getMovieByTitle(@PathVariable String movieTitle) {
        Movie movie = movieService.getMovieByTitle(movieTitle);
        String result = "<h1>" + movie.getTitle() + "</h1> <p>" + movie.getLength() + " min, ";
        if (movie.isAdult()) {
            result += "for adults</p>";
        } else {
            result += "for all audiences</p>";
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public void addMovie(HttpServletResponse response, @ModelAttribute("movie") Movie movie) throws IOException {
        movieService.addMovie(movie);
        response.sendRedirect("/movies");
    }
}
