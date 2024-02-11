package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MovieService {
    public String addDirector;
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(Movie movie){
    String ans=movieRepository.addMovie(movie);
    return ans;
    }
    public String addDirector(Director director){
        String ans=movieRepository.addDirector(director);
        return ans;
    }
    public String pairMovieDirector(String movieName,String directorName){
    return movieRepository.pairMovieDirector(movieName,directorName);
    }
    public String removeDirector(String directorName){
        return movieRepository.removeDirector(directorName);
    }

    public Movie getMovieByName(String name) {
        return movieRepository.getMovieByName(name);

    }

    public Director getDirectorByName(String name) {
        return movieRepository.getDirectorByName(name);

    }

    public List<String> getMoviesByDirectorName(String director) {
        return movieRepository.getMoviesByDirectorName(director);
    }
}