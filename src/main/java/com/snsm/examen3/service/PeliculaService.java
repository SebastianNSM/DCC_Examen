package com.snsm.examen3.service;

import com.snsm.examen3.model.Pelicula;
import com.snsm.examen3.repository.PeliculaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    public Pelicula createPelicula(String title, int budget, float runtime, String lang, String releaseDate) {
        Pelicula peli = new Pelicula();
        peli.setTitle(title);
        peli.setBudget(budget);
        peli.setRuntime(runtime);
        peli.setLang(lang);
        peli.setReleaseDate(LocalDate.parse(releaseDate));
        return this.peliculaRepository.save(peli);
    }

    public Pelicula updatePelicula(int id, String title, int budget, float runtime, String lang, String releaseDate) {
        Pelicula peli = new Pelicula();
        peli.setId(id);
        peli.setTitle(title);
        peli.setBudget(budget);
        peli.setRuntime(runtime);
        peli.setLang(lang);
        peli.setReleaseDate(LocalDate.parse(releaseDate));
        return this.peliculaRepository.save(peli);
    }

    public void deletePelicula(int id) {
        this.peliculaRepository.deleteById(id);
    }

    public List<Pelicula> getAll() {
        return this.peliculaRepository.findAll();
    }

    public Optional<Pelicula> getById(int id) {
        return this.peliculaRepository.findById(id);
    }

    public List<Pelicula> getByTitleLike(String text) {
        return this.peliculaRepository.findByTitleContainingIgnoreCase(text);
    }

    public List<Pelicula> getByBudgetRange(int min, int max) {
        return this.peliculaRepository.findByBudgetBetween(min, max);
    }

    public List<Pelicula> getByTimeRange(float min, float max) {
        return this.peliculaRepository.findByRuntimeBetweenOrderByRuntime(min, max);
    }

    public List<Pelicula> getAllFromDayOfMonth(int month, int day) {
        List<Pelicula> lst = this.peliculaRepository.findAll();
        return lst.stream()
                .filter(p -> p.getReleaseDate().getMonthValue() == month && p.getReleaseDate().getDayOfMonth() == day)
                .collect(Collectors.toList());
    }

    public List<Pelicula> getAllFromYear(int year) {
        List<Pelicula> lst = this.peliculaRepository.findAll();
        return lst.stream().filter(p -> p.getReleaseDate().getYear() == year).collect(Collectors.toList());
    }

}
