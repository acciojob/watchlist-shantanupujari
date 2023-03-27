package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService service;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        service.addMovie(movie);
        return new ResponseEntity<>("Movie Added Succecfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        service.addDirector(director);
        return new ResponseEntity<>("Director Added Succecfully", HttpStatus.CREATED);
    }
    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie ,@RequestParam String director){
        service.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("Pair Added Succecfully", HttpStatus.CREATED);
    }
    @GetMapping("/getMovieByName/{movieName}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("movieName")String name)
    {
        return service.getMovieByName(name);
    }

    @GetMapping("/getDirectorByName/{directorName}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("directorName") String name)
    {
        return service.getDirectorByName(name);
    }

    @GetMapping("/getMoviesByDirectorName/{directorName}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("directorName")String name)
    {
        return service.getMoviesByDirectorName(name);
    }

    @GetMapping("/findAllMovies")
    public ResponseEntity<List<String>> findAllMovies()
    {
        return service.findAllMovies();
    }

    @DeleteMapping("/deleteDirectorByName/{directorName}")
    public ResponseEntity<String> deleteDirectorByName(@PathVariable("directorName") String name)
    {
        return service.deleteDirectorByName(name);
    }

    @DeleteMapping("/deleteAllDirectors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        return service.deleteAllDirectors();
    }


}
