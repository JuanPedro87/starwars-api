package com.example.start.wars.repository;

import com.example.start.wars.model.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by jpcs1 on 30/06/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PeopleRepositoryTest {
    @Autowired
    private PeopleRepository repository;

    /**
     * te pone el autowired automaticamente
     */
    //public PlanetRepositoryTest(PlanetRepository planetRepository) {
    //    this.repository = planetRepository;
    //}

    @Test
    public void should_fin_by_name()throws Exception {
        //Alderaan
        People element = repository.findByNameIgnoreCase("Alderaan");
        assertThat(element.getName(), is("Alderaan"));

    }

    @Test
    public void should_fin_top_20_people()throws Exception {
        //Alderaan
        List<People> elements = repository.findFirst20ByOrderByMassDesc();
        assertNotNull(elements);

    }

}
