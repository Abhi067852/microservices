package com.movie.ratingdataservice.controller;

import com.movie.ratingdataservice.model.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rating")
public class RatingDataController {

    public Rating getRating(@PathVariable String id)
    {
        return new Rating(id,9);
    }
}
