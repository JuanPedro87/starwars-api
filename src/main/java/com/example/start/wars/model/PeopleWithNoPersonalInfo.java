package com.example.start.wars.model;

/**
 * Created by jpcs1 on 14/07/17.
 */

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "peopleWithNoPersonalInfo", types = People.class)
public interface PeopleWithNoPersonalInfo {
    String getName();
    String getBrithYear();
}
