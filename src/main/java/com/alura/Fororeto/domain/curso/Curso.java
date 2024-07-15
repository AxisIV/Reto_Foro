package com.alura.Fororeto.domain.curso;

import com.alura.Fororeto.domain.Topico.Topico;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "curso")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;

    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos;

    public Curso(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }
}
