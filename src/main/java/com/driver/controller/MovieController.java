package com.driver.controller;

import com.driver.models.Director;
import com.driver.models.Movie;
import com.driver.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController
{
    MovieService movieService=new MovieService();

    @PostMapping("/addMovie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {
        return movieService.addMovie(movie);
    }

    @PostMapping("/addDirector")
    public ResponseEntity<String > addDirector(@RequestBody Director director) {

        return movieService.addDirector(director);
    }

    @PutMapping("/addMovieDirectorPair")
    public ResponseEntity<String>addMovieDirectorPair(@RequestParam("movieName") String movie,@RequestParam("directorName") String director)
    {
        return movieService.addMovieDirectorPair(movie,director);
    }

    @GetMapping("/getMovieByName/{movieName}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("movieName")String name)
    {
        return movieService.getMovieByName(name);
    }

    @GetMapping("/getDirectorByName/{directorName}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("directorName") String name)
    {
        return movieService.getDirectorByName(name);
    }

    @GetMapping("/getMoviesByDirectorName/{directorName}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("directorName")String name)
    {
        return movieService.getMoviesByDirectorName(name);
    }

    @GetMapping("/findAllMovies")
    public ResponseEntity<List<String>> findAllMovies()
    {
        return movieService.findAllMovies();
    }

    @DeleteMapping("/deleteDirectorByName/{directorName}")
    public ResponseEntity<String> deleteDirectorByName(@PathVariable("directorName") String name)
    {
        return movieService.deleteDirectorByName(name);
    }

    @DeleteMapping("/deleteAllDirectors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        return movieService.deleteAllDirectors();
    }



}