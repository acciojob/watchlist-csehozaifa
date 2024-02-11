//package com.driver;
//
//
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class MovieRepository {
//    /*
//    HashMap<String, Movie> movieDb = new HashMap<>();
//    HashMap<String, Director> directorDb = new HashMap<>();
//    HashMap<String, String> movieDirectorPair = new HashMap<>();
//
//    public String addMovie(Movie movie) {
//        String key = movie.getName();
//        movieDb.put(key, movie);
//        return "movie added successfully";
//    }
//
//    public String addDirector(Director director) {
//        String key = director.getName();
//        directorDb.put(key, director);
//        return "director added successfully";
//    }
//    public String pairMovieDirector(String movieName,String directorName){
//    movieDirectorPair.put(movieName,directorName);
//    return "connect them successfully";
//    }
//
//    public String removeDirector(String directorName) {
//        //directordb
//        //i also need to delete the entries  in movieDirector Hashmap
//        //corresponding movie
//        directorDb.remove(directorName);
//        //
//        //iterate the complete hashmap
//        for(Map.Entry<String,String> entry:movieDirectorPair.entrySet()){
//            if(entry.getValue().equals(directorName)){
//                String movieName= entry.getKey();
//                movieDb.remove(movieName);
//                movieDirectorPair.remove(movieName);
//            }
//        }
//        return "director remove successfully";
//    }
//    public String removeEverything(){
//        for(String directorName:directorDb.keySet()){
//            directorDb.remove(directorName);
//            //
//            //iterate the complete hashmap
//            for(Map.Entry<String,String> entry:movieDirectorPair.entrySet()){
//                if(entry.getValue().equals(directorName)){
//                    String movieName= entry.getKey();
//                    movieDb.remove(movieName);
//                    movieDirectorPair.remove(movieName);
//                }
//            }
//        }
//
//        return "add director deleted";
//    }
//    public List<Movie> findListOfMovies(String directorName){
//        List<Movie> movies=new ArrayList<>();
//        for(Map.Entry<String,String> entry:movieDirectorPair.entrySet()){
//            if(entry.getValue().equals(directorName)){
//                String movieName= entry.getKey();
//                Movie movie=movieDb.get(movieName);
//                movies.add(movie);
//            }
//        }
//        return movies;
//    }
//
//    public Movie getMovieByName(String name) {
//
//        return movieDb.get(name);
//    }
//
//    public Director getDirectorByName(String name) {
//        return directorDb.get(name);
//    }
//
//    public List<String> getMoviesByDirectorName(Object directorName) {
//        List<String> movies = new ArrayList<>();
//        for (Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
//            if (entry.getValue().equals(directorName)) {
//                movies.add(entry.getKey());
//            }
//        }
//        return movies;
//    }
//
// */
//    private final Map<String, Movie> movieMap = new HashMap<>();
//    private final Map<String, Director> directorMap = new HashMap<>();
//    private final Map<String, String> movieDirectorPair = new HashMap<>();
//public void addMovie(Movie movie) {
//    movieMap.put(movie.getName(), movie);
//}
//
//    public void addDirector(Director director) {
//        directorMap.put(director.getName(), director);
//    }
//
//    public void addMovieDirectorPair(String movieName, String directorName) {
//        movieDirectorPair.put(movieName, directorName);
//    }
//
//    public Movie getMovieByName(String name) {
//        return movieMap.get(name);
//    }
//
//    public Director getDirectorByName(String name) {
//        return directorMap.get(name);
//    }
//
//    public List<String> getMoviesByDirectorName(String directorName) {
//        List<String> movies = new ArrayList<>();
//        for (Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
//            if (entry.getValue().equals(directorName)) {
//                movies.add(entry.getKey());
//            }
//        }
//        return movies;
//    }
//
//    public List<String> findAllMovies() {
//        List<String> movies = new ArrayList<>(movieMap.keySet());
//        return movies;
//    }
//
//    public void deleteDirectorByName(String directorName) {
//        directorMap.remove(directorName);
//        for (Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
//            if (entry.getValue().equals(directorName)) {
//                movieMap.remove(entry.getKey());
//                movieDirectorPair.remove(entry.getKey());
//            }
//        }
//    }
//
//    public void deleteAllDirectors() {
//        directorMap.clear();
//        movieDirectorPair.clear();
//    }
//}
//

package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

@Repository
public class MovieRepository {
    HashMap<String, Movie> movieDB = new HashMap<>();
    HashMap<String, Director> directorDB = new HashMap<>();
    HashMap<String, List<String>> directorMovieDB = new HashMap<>();

    public String addMovie(Movie movie) {
        String moviename = movie.getName();

        movieDB.put(moviename, movie);
        return "successfully movie added";
    }

    public String addDirector(Director director) {
        String directorname = director.getName();
        directorDB.put(directorname, director);
        return "successfully director added";
    }

    public List<Movie> getAllMovies() {
        List<Movie> list = new ArrayList<>();
        for (Movie movie : movieDB.values()) {
            list.add(movie);
        }
        return list;
    }

    public List<Director> getAllDirectors() {
        List<Director> list = new ArrayList<>();
        for (Director director : directorDB.values()) {
            list.add(director);
        }
        return list;
    }

    public List<String> findAllMovies() {
        List<String> list = new ArrayList<>();
        for (String s : movieDB.keySet()) {
            list.add(s);
        }
        return list;
    }

    public List<String> getMoviesByDirectorName(String name) {
        List<String> movieList =new ArrayList<>();
        for(String directorname:directorMovieDB.keySet())
            if (directorname.equals(name)) {
                return directorMovieDB.get(directorname);
            }
        return movieList;
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        if(!directorMovieDB.containsKey(directorName)){
            List<String> movieList= new ArrayList<>();
            movieList.add(movieName);
            directorMovieDB.put(directorName,movieList);
        }
        else{
            directorMovieDB.get(directorName).add(movieName);
        }

        return "successfully added";
    }

    public  String deleteDirectorByName(String directorName) {
        if(directorMovieDB.containsKey(directorName)){
            List<String> moviesByDirector=directorMovieDB.get(directorName);
            for(String movieName: moviesByDirector){
                deleteByMovieName(movieName);
            }
            directorMovieDB.remove(directorName);
        }
        if(directorDB.containsKey(directorName))
            directorDB.remove(directorName);
        return "successfully deleted";
    }

    public void deleteByMovieName(String movieName) {
        if(movieDB.containsKey(movieName)){
            movieDB.remove(movieName);
        }
    }
    public String deleteAllDirectors() {
        List<String> directorsList=new ArrayList<>();
        for(String directorname:directorDB.keySet()){
            directorsList.add(directorname);
        }
        for(String directorName:directorsList){
            if(directorMovieDB.containsKey(directorName)){
                List<String> moviesByDirector=directorMovieDB.get(directorName);
                for(String movieName: moviesByDirector){
                    deleteByMovieName(movieName);
                }
            }
            directorDB.clear();
            directorMovieDB.clear();}
        return "successfully deleted all directors";
    }
}

