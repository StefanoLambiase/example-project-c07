package it.unisa.c07.exampleprojectc07.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descrizione;
    private int numeroCopie;

    public Libro(String nome, String descrizione, int numeroCopie) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.numeroCopie = numeroCopie;
    }
}
