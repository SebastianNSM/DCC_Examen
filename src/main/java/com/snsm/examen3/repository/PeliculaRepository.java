package com.snsm.examen3.repository;

import java.time.LocalDate;
import java.util.List;

import com.snsm.examen3.model.Pelicula;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PeliculaRepository
 */
@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    List<Pelicula> findByTitleContainingIgnoreCase(String text);

    List<Pelicula> findByBudgetBetween(int min, int max);

    List<Pelicula> findByRuntimeBetweenOrderByRuntime(float min, float max);

    List<Pelicula> findByReleaseDate(LocalDate date);
}
