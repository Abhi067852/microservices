package com.movie.movieinfoservice.controller;

import com.movie.movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class MovieInfoController {
    @GetMapping("/{id}")
    public Movie getMovieInfo(@PathVariable String id) {
        return new Movie(id,"Shawshank Redemption");
    }
}
