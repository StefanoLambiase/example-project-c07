package it.unisa.c07.exampleprojectc07.libro.dao;

import it.unisa.c07.exampleprojectc07.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroDAO extends JpaRepository<Libro, Long> {
}
