package com.driver.service;

import com.driver.models.Director;import com.driver.models.Movie;import com.driver.repository.MovieRepository;import org.springframework.http.HttpStatus;import org.springframework.http.ResponseEntity;import org.springframework.stereotype.Service;import java.util.List;
@Service
public class MovieService
{
    MovieRepository movieRepository=new MovieRepository();

    public ResponseEntity<String> addMovie(Movie movie)
    {
        return movieRepository.addMovie(movie);
    }


    public ResponseEntity<String> addDirector(Director director)
    {
        return movieRepository.addDirector(director);
    }

    public ResponseEntity<String> addMovieDirectorPair(String movie,String director)
    {
        return movieRepository.addMovieDirectorPair(movie,director);
    }

    public ResponseEntity<Movie> getMovieByName(String movieName)
    {
        Movie movie=movieRepository.getMovieByName(movieName);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    public ResponseEntity<Director> getDirectorByName(String directorName)
    {
        Director director=movieRepository.getDirectorByName(directorName);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    public ResponseEntity<List<String>> getMoviesByDirectorName(String directorName)
    {
        return new ResponseEntity<List<String>>(movieRepository.getMoviesByDirectorName(directorName),HttpStatus.OK);
    }

    public ResponseEntity<List<String>> findAllMovies()
    {
        List<String> res=movieRepository.findAllMovies();

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteDirectorByName(String directorName)
    {
        movieRepository.deleteDirectorByName(directorName);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    public ResponseEntity<String> deleteAllDirectors()
    {
        movieRepository.deleteAllDirectors();
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }
}