package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    HashMap<String, Movie> movieDb = new HashMap<>();
    HashMap<String, Director> directorDb = new HashMap<>();
    HashMap<String, String> movieDirectorPair = new HashMap<>();

    public String addMovie(Movie movie) {
        String key = movie.getName();
        movieDb.put(key, movie);
        return "movie added successfully";
    }

    public String addDirector(Director director) {
        String key = director.getName();
        directorDb.put(key, director);
        return "director added successfully";
    }
    public String pairMovieDirector(String movieName,String directorName){
    movieDirectorPair.put(movieName,directorName);
    return "connect them successfully";
    }

    public String removeDirector(String directorName) {
        //directordb
        //i also need to delete the entries  in movieDirector Hashmap
        //corresponding movie
        directorDb.remove(directorName);
        //
        //iterate the complete hashmap
        for(Map.Entry<String,String> entry:movieDirectorPair.entrySet()){
            if(entry.getValue().equals(directorName)){
                String movieName= entry.getKey();
                movieDb.remove(movieName);
                movieDirectorPair.remove(movieName);
            }
        }
        return "director remove successfully";
    }
    public String removeEverything(){
        for(String directorName:directorDb.keySet()){
            directorDb.remove(directorName);
            //
            //iterate the complete hashmap
            for(Map.Entry<String,String> entry:movieDirectorPair.entrySet()){
                if(entry.getValue().equals(directorName)){
                    String movieName= entry.getKey();
                    movieDb.remove(movieName);
                    movieDirectorPair.remove(movieName);
                }
            }
        }

        return "add director deleted";
    }
    public List<Movie> findListOfMovies(String directorName){
        List<Movie> movies=new ArrayList<>();
        for(Map.Entry<String,String> entry:movieDirectorPair.entrySet()){
            if(entry.getValue().equals(directorName)){
                String movieName= entry.getKey();
                Movie movie=movieDb.get(movieName);
                movies.add(movie);
            }
        }
        return movies;
    }

    public Movie getMovieByName(String name) {

        return movieDb.get(name);
    }

    public Director getDirectorByName(String name) {
        return directorDb.get(name);
    }

    public List<String> getMoviesByDirectorName(Object directorName) {
        List<String> movies = new ArrayList<>();
        for (Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
            if (entry.getValue().equals(directorName)) {
                movies.add(entry.getKey());
            }
        }
        return movies;
    }
}