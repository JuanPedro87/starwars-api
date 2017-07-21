package com.example.start.wars.controller;

import com.example.start.wars.model.Film;
import com.example.start.wars.repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by jpcs1 on 14/07/17.
 */
@RepositoryRestController
@AllArgsConstructor
public class FilmController {
    private FilmRepository filmRepository;

    @RequestMapping(method = RequestMethod.GET, value = "films/search/findAllByOrderByEpisodeIdAsc")
    public @ResponseBody ResponseEntity<Film> callMethod(@Param("releaseDate")
                                                          @DateTimeFormat(pattern = "yyyy-mm-dd'T'HH:mm:ss") Date releaseDate) {
        List<Film> films=filmRepository.findAllByReleaseDateGreaterThan(releaseDate);
        Resources<Film> resources = new Resources<>(films);

        resources.forEach(resource -> {
            resource.getDirector();
            resource.add(new Link("wwwibm.com"));
        });

        return new ResponseEntity(resources, HttpStatus.OK);
    }
}
