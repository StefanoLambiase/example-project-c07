package it.unisa.c07.exampleprojectc07.libro.controller;

import it.unisa.c07.exampleprojectc07.entity.Libro;
import it.unisa.c07.exampleprojectc07.libro.service.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/libro")
public class LibroController {

    private final LibroService libroService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String findAllLibro(Model model) {
        List<Libro> libroList = this.libroService.findAllLibro();

        model.addAttribute("libroList", libroList);
        return "libro/libro_list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addLibro(Libro libro) {
        this.libroService.saveLibro(libro);
        return "redirect:/libro/";
    }
}
