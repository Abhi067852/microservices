package com.movie.moviecatalogservice.items;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Setter
@Getter
public class Rating {
    private String id;
    private int rating;

}
