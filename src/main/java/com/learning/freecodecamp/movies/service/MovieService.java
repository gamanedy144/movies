package com.learning.freecodecamp.movies.service;

import com.learning.freecodecamp.movies.entity.Movie;
import com.learning.freecodecamp.movies.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MovieService {
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovieById(ObjectId id) {
        return movieRepository.findById(id);
    }
    public Optional<Movie> singleMovieByImdbId(String id) {
        return movieRepository.findMovieByImdbId(id);
    }
}
