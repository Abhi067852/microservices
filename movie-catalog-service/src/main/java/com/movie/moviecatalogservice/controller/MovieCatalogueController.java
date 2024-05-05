package com.movie.moviecatalogservice.controller;

import com.movie.moviecatalogservice.items.CatalogueItem;
import com.movie.moviecatalogservice.items.Movie;
import com.movie.moviecatalogservice.items.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogueController {

    @Autowired
    private RestTemplate restTemplate;
   @GetMapping("/{id}")
    public List<CatalogueItem> getCatalogue(@PathVariable  String id)
    {
        //get all rated movie Id

        List<Rating> ratings= Arrays.asList(
                new Rating("1",10),
                new Rating("2",8)
        );

        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("https://localhost:8081/movies/"+rating.getId(), Movie.class);
            return new CatalogueItem(movie.getMovieName(),"asdfj",rating.getRating());
        }).collect(Collectors.toList());

//        //for each movieId call movie info service and get details
//        CatalogueItem catalogueItem1 = new CatalogueItem("Top Gun Maverick","One time watch",8);
//        CatalogueItem catalogueItem2 = new CatalogueItem("Shawshank Redemption","Top G movie",10);
//        System.out.println(catalogueItem1.getName());
//        List<CatalogueItem> catalogueItems = new ArrayList<>();
//        catalogueItems.add(catalogueItem2);
//        catalogueItems.add(catalogueItem1);
//        return catalogueItems;
    }
}
