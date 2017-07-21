package com.example.start.wars.model;

import org.springframework.data.rest.core.config.Projection;

/**
 * Created by jpcs1 on 14/07/17.
 */

@Projection(name = "PlanetWithOnlyNameAndPopulation", types = Planet.class)
public interface PlanetWithOnlyNameAndPopulation {
    String getName();
    Integer getPopulation();
}
