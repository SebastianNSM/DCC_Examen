package com.snsm.examen3.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Pelicula
 */
@Entity
@Data
@EqualsAndHashCode
@Table(name = "T_PELICULA")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "original_title", nullable = false)
    private String title;

    @Column(name = "budget", nullable = false)
    private int budget;

    @Column(name = "runtime", nullable = false)
    private float runtime;

    @Column(name = "original_language", nullable = false)
    private String lang;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

}
