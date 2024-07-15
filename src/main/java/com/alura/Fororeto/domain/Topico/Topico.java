package com.alura.Fororeto.domain.Topico;

import com.alura.Fororeto.domain.Usuarios.Usuario;
import com.alura.Fororeto.domain.curso.Curso;
import com.alura.Fororeto.domain.respuesta.Respuesta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String status;

    @ManyToOne
    @JoinColumn(name = "autor", referencedColumnName = "id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso", referencedColumnName = "id")
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = datosRegistroTopico.fechaCreacion();
        this.status = "ACTIVO";
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
        this.respuestas = new ArrayList<>();
    }
}
