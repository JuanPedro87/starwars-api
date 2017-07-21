package com.example.start.wars.repository;

import com.example.start.wars.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

/**
 * Created by jpcs1 on 30/06/17.
 */
@RepositoryRestResource
//@Secured() // permitir a alquien
@PreAuthorize("hasRole(ADMIN)") //para ver sitenias permisos antes
//@PostAuthorize() // para ver si ya tenias permisos despues
public interface PlanetRepository extends JpaRepository<Planet, Long> {

    Optional<Planet> findByName(String name);
    List<Planet> findByNameContaining(String name);
    List<Planet> findAllByOrderByNameDesc();
    List<Planet> findByPopulationGreaterThan(Long population);
    List<Planet> findByPopulationBetween(Long min,Long max);
    List<Planet> findTop10ByOrderByPopulationAsc();
    List<Planet> findTop10ByOrderByPopulationDesc();

    Boolean deleteByPlanetId(Long id);


}
