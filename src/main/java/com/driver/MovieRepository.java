package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
HashMap <String, Movie> movieDB = new HashMap<>();
HashMap<String , Director>directorDB = new HashMap<>();

HashMap<String ,List<String>>movieDirectorPairDB = new HashMap<>();



public void addMovie(Movie movie){
    String key = movie.getName();
    movieDB.put(key,movie);
}
public void addDirector(Director director){
String key = director.getName();
directorDB.put(key, director);
}
    public void addMovieDirectorPair(String movie , String director){
    if (movieDirectorPairDB.containsKey(movie)){
        List<String> list= movieDirectorPairDB.get(director);
        list.add(movie);
        movieDirectorPairDB.put(director,list);
    }
    else{
        List<String>list= new ArrayList<>();
        list.add(movie);
        movieDirectorPairDB.put(director,list);
    }
    }
    public Movie getMovieByName(String movieName)
    {


        return movieDB.get(movieName);
    }
    public Director getDirectorByName(String directorName)
    {


        return directorDB.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName)
    {


        return movieDirectorPairDB.get(directorName);
    }

    public List<String>findAllMovies()
    {
        List<String> result=new ArrayList<>();
        for (Movie movie:movieDB.values())
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
            movieDB.remove(name);
        }
        movieDirectorPairDB.remove(directorName);
        directorDB.remove(directorName);
    }

    public void deleteAllDirectors()
    {
        List<String> directors=new ArrayList<>();

        for (Director director:directorDB.values())
        {
            directors.add(director.getName());
        }

        for(String directorName:directors)
        {
            deleteDirectorByName(directorName);

        }
    }

}








