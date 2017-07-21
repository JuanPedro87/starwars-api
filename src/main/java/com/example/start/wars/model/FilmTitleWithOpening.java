package com.example.start.wars.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

/**
 * Created by jpcs1 on 14/07/17.
 */
@Projection(name = "FilmTitleWithOpening", types = Film.class)
public interface FilmTitleWithOpening {
    String getTitle();
    String getOpeningCrawl();
    List<PeopleWithNoPersonalInfo> getPeople();
}
