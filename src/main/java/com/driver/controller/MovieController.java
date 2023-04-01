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
    public ResponseEntity<String> addmovie(@RequestBody Movie movie)
    {
        return movieService.addMovie(movie);
    }

    @PostMapping("/addDirector")
    public ResponseEntity<String >adddirector(@RequestBody Director director) {

        return movieService.addDirector(director);
    }

    @PutMapping("/addMovieDirectorPair")
    public ResponseEntity<String>addmoviedirectorpair(@RequestParam("movieName") String movie,@RequestParam("directorName") String director)
    {
        return movieService.addMovieDirectorPair(movie,director);
    }

    @GetMapping("/getMovieByName/{movieName}")
    public ResponseEntity<Movie> getmoviebyname(@PathVariable("movieName")String name)
    {
        return movieService.getMovieByName(name);
    }

    @GetMapping("/getDirectorByName/{directorName}")
    public ResponseEntity<Director> getdirectorbyname(@PathVariable("directorName") String name)
    {
        return movieService.getDirectorByName(name);
    }

    @GetMapping("/getMoviesByDirectorName/{directorName}")
    public ResponseEntity<List<String>> getmoviesbydirectorname(@PathVariable("directorName")String name)
    {
        return movieService.getMoviesByDirectorName(name);
    }

    @GetMapping("/findAllMovies")
    public ResponseEntity<List<String>> getallmovies()
    {
        return movieService.findAllMovies();
    }

    @DeleteMapping("/deleteDirectorByName/{directorName}")
    public ResponseEntity<String>deletedirectorbyname(@PathVariable("directorName") String name)
    {
        return movieService.deleteDirectorByName(name);
    }

    @DeleteMapping("/deleteAllDirectors")
    public ResponseEntity<String> deletealldirectors()
    {
        return movieService.deleteAllDirectors();
    }



}