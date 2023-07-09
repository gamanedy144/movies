package com.learning.freecodecamp.movies.controller;

import com.learning.freecodecamp.movies.entity.Movie;
import com.learning.freecodecamp.movies.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {


    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String id){
        return new ResponseEntity<>(movieService.singleMovieByImdbId(id), HttpStatus.OK);
    }
}
