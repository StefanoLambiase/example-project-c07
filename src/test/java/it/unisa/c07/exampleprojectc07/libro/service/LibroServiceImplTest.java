package it.unisa.c07.exampleprojectc07.libro.service;

import it.unisa.c07.exampleprojectc07.entity.Libro;
import it.unisa.c07.exampleprojectc07.libro.dao.LibroDAO;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(SpringRunner.class)
public class LibroServiceImplTest {

    @InjectMocks
    private LibroServiceImpl libroService;

    @Mock
    private LibroDAO libroDAO;

    @Test
    public void findAllLbiro() {
        Libro libro = new Libro();
        List<Libro> libroList = new ArrayList<>();
        libroList.add(libro);

        when(libroDAO.findAll()).thenReturn(libroList);     // Mockito entra in azione!!!

        assertEquals(libroList, libroService.findAllLibro());       // JUnit entra in azione!!!
    }

}
