package com.example.start.wars.repository;

import com.example.start.wars.model.Film;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by jpcs1 on 30/06/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmRepositoryTest {
    @Autowired
    private FilmRepository repository;

    /**
     * te pone el autowired automaticamente
     */
    //public PlanetRepositoryTest(PlanetRepository planetRepository) {
    //    this.repository = planetRepository;
    //}


    @Test
    public void should_find_20_film()throws Exception {
        //Alderaan
        List<Film> elements = repository.findAllByOrderByEpisodeIdAsc();
        assertNotNull(elements);

    }

    @Test
    public void print_all()throws Exception {
        //Alderaan
        List<Film> elements = repository.findAll();
        elements.stream().forEach(System.out::println);

    }

    @Test
    public void should_find_min_film()throws Exception {
        //Alderaan
        List<Film> elements = repository.findAllByMinFilm();
        assertNotNull(elements);

    }

    @Test
    public void should_findAllByFilmContains()throws Exception {
        //Alderaan
        List<Film> elements = repository.findAllByFilmContains("Luke Skywalker");
        assertNotNull(elements);

    }


//    @Test
//    public void should_print_all()throws Exception {
//        List<Film> all = repository.findAll();
//        for (Film element:all ) {
//            repository.logFilm(element);
//
//        }
//    }
}
