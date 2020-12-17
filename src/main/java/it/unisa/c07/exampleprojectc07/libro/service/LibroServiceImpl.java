package it.unisa.c07.exampleprojectc07.libro.service;

import it.unisa.c07.exampleprojectc07.entity.Libro;
import it.unisa.c07.exampleprojectc07.libro.dao.LibroDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroServiceImpl implements LibroService {

    private final LibroDAO libroDAO;

    @Override
    public List<Libro> findAllLibro() {
        return libroDAO.findAll();
    }

    @Override
    public void saveLibro(Libro libro) {
        libroDAO.save(libro);
    }
}
