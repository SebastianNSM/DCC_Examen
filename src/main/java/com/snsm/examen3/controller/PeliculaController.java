package com.snsm.examen3.controller;

import java.util.List;

import com.snsm.examen3.model.Pelicula;
import com.snsm.examen3.service.PeliculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PeliculaController
 */
@RestController
@RequestMapping("/rest")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> getAll() {
        return peliculaService.getAll();
    }

    @GetMapping("title/{title}")
    public List<Pelicula> getAllByTitle(@PathVariable("title") String title) {
        return peliculaService.getByTitleLike(title);
    }

    @GetMapping("duration/{min_time}/{max_time}")
    public List<Pelicula> getAllByTime(@PathVariable("min_time") float min, @PathVariable("max_time") float max) {
        return peliculaService.getByTimeRange(min, max);
    }

    @GetMapping("date/{month}/{day}")
    public List<Pelicula> getAllFromDayOfMonth(@PathVariable("month") int month, @PathVariable("day") int day) {
        return peliculaService.getAllFromDayOfMonth(month, day);
    }

    @GetMapping("year/{year}")
    public List<Pelicula> getAllFromYear(@PathVariable("year") int year) {
        return peliculaService.getAllFromYear(year);
    }

    @GetMapping("noe")
    public List<Pelicula> getAllByBudget() {
        return peliculaService.getAll();
    }

    @GetMapping("budget/{min}/{max}")
    public List<Pelicula> getAllByBudget(@PathVariable("min") int min, @PathVariable("max") int max) {
        return peliculaService.getByBudgetRange(min, max);
    }
}
