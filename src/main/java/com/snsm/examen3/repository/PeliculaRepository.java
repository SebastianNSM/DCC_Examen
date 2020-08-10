package com.snsm.examen3.repository;

import com.snsm.examen3.model.Pelicula;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * PeliculaRepository
 */
@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    List<Pelicula> findByTitleContainingIgnoreCase(String text);

    List<Pelicula> findByBudgetBetween(int min, int max);

    List<Pelicula> findByRuntimeBetweenOrderByRuntime(float min, float max);
}
