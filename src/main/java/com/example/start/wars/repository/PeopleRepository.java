package com.example.start.wars.repository;

import com.example.start.wars.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;

/**
 * Created by jpcs1 on 30/06/17.
 */
@RepositoryRestResource
public interface PeopleRepository  extends JpaRepository<People, Long>{
    People findByNameIgnoreCase(String name);
    List<People> findByNameContaining(String name);
    List<People> findByHeightGreaterThanEqual(String heigth);
    List<People> findByEyeColorIn(Collection<String> colors);
    List<People> findFirst20ByOrderByMassDesc();
    List<People> findByEyeColorIs(String colors);
    // native query para usar sql
    //sin native query es un lenguage propio de JPA
    @Query(value = "select * from People where name like 'S%'", nativeQuery = true)
    List<People> findByNameStartingWith1();

    // con parametros
    @Query(value = "select * from People where name like :name", nativeQuery = true)
    List<People> findByNameStartingWith2(@Param("name")String name);

    // tb funciona el predicado: findByNameStartingWith
    List<People> findByNameStartingWith(String name);

}
