package com.alura.Fororeto.domain.Topico;

import com.alura.Fororeto.domain.Usuarios.Usuario;
import com.alura.Fororeto.domain.curso.Curso;
import com.alura.Fororeto.domain.respuesta.Respuesta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DatosActualizacionTopico(@NotNull Long id,
                                       @NotBlank String titulo,
                                       @NotBlank String mensaje,
                                       @NotNull Curso curso,
                                       @NotNull Usuario autor,
                                       @NotNull List<Respuesta> respuestas) {
}
