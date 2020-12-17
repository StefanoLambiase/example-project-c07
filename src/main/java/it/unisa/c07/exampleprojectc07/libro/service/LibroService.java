package it.unisa.c07.exampleprojectc07.libro.service;

import it.unisa.c07.exampleprojectc07.entity.Libro;

import java.util.List;

public interface LibroService {

    List<Libro> findAllLibro();

    void saveLibro(Libro libro);
}
