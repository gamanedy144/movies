package com.learning.freecodecamp.movies.service;

import com.learning.freecodecamp.movies.entity.Movie;
import com.learning.freecodecamp.movies.entity.Review;
import com.learning.freecodecamp.movies.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
