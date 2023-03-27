package com.driver.repository;

import com.driver.models.Director;
import com.driver.models.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;import java.util.ArrayList;import java.util.HashMap;import java.util.List;

@Repository
public class MovieRepository
{
    HashMap<String,Movie> movieDb=new HashMap<>();

    HashMap<String, Director> directorDb = new HashMap<>();

    HashMap<String,List<String>> directorMovieDb = new HashMap<>();


    public  ResponseEntity<String> addMovie(Movie movie)
    {
        String key=movie.getName();

        movieDb.put(key,movie);

        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    public ResponseEntity<String> addDirector(Director director)
    {
        String key=director.getName();
        directorDb.put(key,director);

        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    public ResponseEntity<String> addMovieDirectorPair(String  movie,String director)
    {
        if (directorMovieDb.containsKey(director))
        {
            List<String> movies=directorMovieDb.get(director);
            movies.add(movie);
            directorMovieDb.put(director,movies);

        }
        else
        {
            List<String> movies=new ArrayList<>();
            movies.add(movie);
            directorMovieDb.put(director,movies);
        }
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    public Movie getMovieByName(String movieName)
    {


        return movieDb.get(movieName);
    }
    public Director getDirectorByName(String directorName)
    {


        return directorDb.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName)
    {


        return directorMovieDb.get(directorName);
    }

    public List<String>findAllMovies()
    {
        List<String> result=new ArrayList<>();
        for (Movie movie:movieDb.values())
        {
            result.add(movie.getName());
        }

        return result;
    }

    public void  deleteDirectorByName(String directorName)
    {
        List<String> movies=getMoviesByDirectorName(directorName);
        for(String name:movies)
        {
            movieDb.remove(name);
        }
        directorMovieDb.remove(directorName);
        directorDb.remove(directorName);
    }

    public void deleteAllDirectors()
    {
        List<String> directors=new ArrayList<>();

        for (Director director:directorDb.values())
        {
            directors.add(director.getName());
        }

        for(String directorName:directors)
        {
            deleteDirectorByName(directorName);

        }
    }


}