package com.example.start.wars.model;

/**
 * te genera getter seteer
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jpcs1 on 30/06/17.
 */
@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
public class
Planet {
    @Id
    @GeneratedValue
    private Long planetId;
    private String name;
    private Integer rotationPeriod;
    private Integer orbitalPeriod;
    private Integer diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surfaceWater;
    private Integer population;

}
