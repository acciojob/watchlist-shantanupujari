package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import java.util.List;
@Service

public class MovieService {
@Autowired
    MovieRepository repository;
   void addMovie(Movie movie){
      repository.addMovie(movie);
   }
   void addDirector(Director director){
       repository.addDirector(director);
   }
   void addMovieDirectorPair(String movie , String director){
       repository.addMovieDirectorPair(movie,director);
   }
    public ResponseEntity<Movie> getMovieByName(String movieName)
    {
        Movie movie=repository.getMovieByName(movieName);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    public ResponseEntity<Director> getDirectorByName(String directorName)
    {
        Director director=repository.getDirectorByName(directorName);

        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    public ResponseEntity<List<String>> getMoviesByDirectorName(String directorName)
    {
        return new ResponseEntity<List<String>>(repository.getMoviesByDirectorName(directorName),HttpStatus.OK);
    }


    public ResponseEntity<List<String>> findAllMovies()
    {
        List<String> res=repository.findAllMovies();

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteDirectorByName(String directorName)
    {
        repository.deleteDirectorByName(directorName);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    public ResponseEntity<String> deleteAllDirectors()
    {
       repository.deleteAllDirectors();
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }
}
