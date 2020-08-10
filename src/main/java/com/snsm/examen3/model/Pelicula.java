package com.snsm.examen3.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
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

    public Pelicula() {

    }

    public Pelicula(int id, String title, int budget, float runtime, String lang, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.budget = budget;
        this.runtime = runtime;
        this.lang = lang;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public float getRuntime() {
        return runtime;
    }

    public void setRuntime(float runtime) {
        this.runtime = runtime;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Pelicula [budget=" + budget + ", id=" + id + ", lang=" + lang + ", releaseDate=" + releaseDate
                + ", runtime=" + runtime + ", title=" + title + "]";
    }

}
