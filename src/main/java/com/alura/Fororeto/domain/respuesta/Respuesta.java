package com.alura.Fororeto.domain.respuesta;

import com.alura.Fororeto.domain.Topico.Topico;
import com.alura.Fororeto.domain.Usuarios.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "respuesta")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean solucion;

    @ManyToOne
    @JoinColumn(name = "topico", referencedColumnName = "id")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "autor", referencedColumnName = "id")
    private Usuario autor;

}
