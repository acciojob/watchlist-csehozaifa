//package com.driver;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/movies")
//public class MovieController {
//    @Autowired
//    MovieService movieService;
//
//    //Alternate incase accio assignment is not getting submitted
//    //Remove autowired and do this
//    //MovieService movieService=new MovieService();
//
///*
//    @GetMapping("/get-movie-by-name/{name}")
//    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name) {
//        Movie movie = movieService.getMovieByName(name);
//        if (movie != null) {
//            return ResponseEntity.ok(movie);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/get-director-by-name/{name}")
//    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name) {
//        Director director = movieService.getDirectorByName(name);
//        if (director != null) {
//            return ResponseEntity.ok(director);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    @PostMapping("/add-movie")
//    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
//    String ans= movieService.addMovie(movie);
//    return new ResponseEntity<>(ans, HttpStatus.CREATED);
//    }
//
//    @PostMapping("/add-director")
//    public ResponseEntity<String> addDirector(@RequestBody Director director){
//        String ans=movieService.addDirector;
//        return new ResponseEntity<>(ans,HttpStatus.CREATED);
//    }
//
//    @PostMapping("/add-movie-director-pair")
//    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName")String movieName,
//                                                       @RequestParam("directorName")String directorName){
//
//        String ans=movieService.pairMovieDirector(movieName,directorName);
//        return new ResponseEntity<>(ans,HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/delete-director-by-name")
//    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName")String directorName){
//        String ans= movieService.removeDirector(directorName);
//        return new ResponseEntity<>(ans, HttpStatus.OK);
//    }
//    @GetMapping("/get-movies-by-director-name/{director}")
//    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String director) {
//        List<String> movies = movieService.getMoviesByDirectorName(director);
//        if (movies != null) {
//            return ResponseEntity.ok(movies);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//*/
//@PostMapping("/add-movie")
//public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
//    movieService.addMovie(movie);
//    return ResponseEntity.status(HttpStatus.CREATED).body("Movie added successfully");
//}
//
//    @PostMapping("/add-director")
//    public ResponseEntity<String> addDirector(@RequestBody Director director) {
//        movieService.addDirector(director);
//        return ResponseEntity.status(HttpStatus.CREATED).body("Director added successfully");
//    }
//
//    @PutMapping("/add-movie-director-pair")
//    public ResponseEntity<String> addMovieDirectorPair(
//            @RequestParam String movieName,
//            @RequestParam String directorName
//    ) {
//        movieService.addMovieDirectorPair(movieName, directorName);
//        return ResponseEntity.status(HttpStatus.CREATED).body("Movie-Director pair added successfully");
//    }
//
//    @GetMapping("/get-movie-by-name/{name}")
//    public ResponseEntity<Movie> getMovieByName(@PathVariable String name) {
//        Movie movie = movieService.getMovieByName(name);
//        if (movie != null) {
//            return ResponseEntity.ok(movie);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/get-director-by-name/{name}")
//    public ResponseEntity<Director> getDirectorByName(@PathVariable String name) {
//        Director director = movieService.getDirectorByName(name);
//        if (director != null) {
//            return ResponseEntity.ok(director);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/get-movies-by-director-name/{director}")
//    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director) {
//        List<String> movies = movieService.getMoviesByDirectorName(director);
//        if (movies != null) {
//            return ResponseEntity.ok(movies);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/get-all-movies")
//    public ResponseEntity<List<String>> findAllMovies() {
//        List<String> movies = movieService.findAllMovies();
//        if (movies != null) {
//            return ResponseEntity.ok(movies);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/delete-director-by-name")
//    public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName) {
//        movieService.deleteDirectorByName(directorName);
//        return ResponseEntity.ok("Director and associated movies deleted successfully");
//    }
//
//    @DeleteMapping("/delete-all-directors")
//    public ResponseEntity<String> deleteAllDirectors() {
//        movieService.deleteAllDirectors();
//        return ResponseEntity.ok("All directors and associated movies deleted successfully");
//    }
//
//}

package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/movies")
@Controller
public class MovieController {


    MovieService movieService= new MovieService();
    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String answer=movieService.addMovie(movie);
        return new ResponseEntity(answer, HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        String answer=movieService.addDirector(director);
        return new ResponseEntity(answer,HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        Optional<Movie> op=movieService.getMovieByName(name);
        if(op.isPresent()){
            return new ResponseEntity(op.get(),HttpStatus.FOUND);
        }
        return new ResponseEntity("Movie Not found",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){
        Optional<Director> op=movieService.getDirectorByName(name);
        if(op.isPresent()){
            return new ResponseEntity(op.get(),HttpStatus.FOUND);
        }
        return new ResponseEntity("Director Not found",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/get-movies-by-director-name/{name}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable String name){
        List<String> movieList=movieService.getMoviesByDirectorName(name);
        return new ResponseEntity(movieList,HttpStatus.FOUND);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> movieList=movieService.findAllMovies();
        return new ResponseEntity(movieList,HttpStatus.FOUND);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String movieName,@RequestParam String directorName){
        String answer=movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity(answer,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String name){
        String answer=movieService.deleteDirectorByName(name);
        return new ResponseEntity(answer,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        String answer=movieService.deleteAllDirectors();
        return new ResponseEntity(answer,HttpStatus.ACCEPTED);
    }
}
