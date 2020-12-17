package it.unisa.c07.exampleprojectc07.libro.controller;

import it.unisa.c07.exampleprojectc07.entity.Libro;
import it.unisa.c07.exampleprojectc07.libro.service.LibroService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class LibroControllerTest {

    @MockBean
    private LibroService libroService;

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("provideFindAllLibro")
    public void findAllLibro(final String nome, final String descrizione, final int numeroCopie) throws Exception {
        Libro libro = new Libro(nome, descrizione, numeroCopie);
        List<Libro> libroList = new ArrayList<>();
        libroList.add(libro);

        /*
        Libro libro1 = new Libro("Stefano", "Stefano", 7);
        List<Libro> libroList1 = new ArrayList<>();
        libroList1.add(libro1);
        */

        when(libroService.findAllLibro()).thenReturn(libroList);

        this.mockMvc.perform(get("/libro/"))
                .andExpect(model().attribute("libroList", libroList))
                .andExpect(view().name("libro/libro_list"));
    }

    private static Stream<Arguments> provideFindAllLibro() {
        return Stream.of(
                Arguments.of("Stefano best PM", "mmmmm ne dubito", 7),
                Arguments.of("Menzogne", "Il libro di prima è falso", 7)
        );
    }

}
