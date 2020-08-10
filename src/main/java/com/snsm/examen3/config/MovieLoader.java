package com.snsm.examen3.config;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.snsm.examen3.service.PeliculaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
class MovieLoader implements CommandLineRunner {

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    PeliculaService peliculaService;

    private final Logger LOGGER = LoggerFactory.getLogger(MovieLoader.class);

    @Override
    public void run(String... args) throws Exception {
        List<String[]> movieList = readMovies();
        movieList.stream().forEach(m -> {
            LOGGER.info("Pelicula registrada:\t" + m[0]);
            peliculaService.createPelicula(m[0], Integer.parseInt(m[1]), Float.parseFloat(m[2]), m[3], m[4]);
        });
    }

    public List<String[]> readMovies() throws Exception {
        Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource("movies_data.csv").toURI()));
        CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(false).build();
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(0).withCSVParser(parser).withSkipLines(1)
                .build();

        List<String[]> list = new ArrayList<>();
        String[] line;
        while ((line = csvReader.readNext()) != null) {
            list.add(line);
        }
        return list;
    }
}
