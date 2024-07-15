package com.alura.Fororeto.domain.Topico;

import com.alura.Fororeto.domain.Usuarios.DatosUsuario;
import com.alura.Fororeto.domain.curso.DatosCurso;
import com.alura.Fororeto.domain.respuesta.Respuesta;

import java.time.LocalDateTime;
import java.util.List;

public record DatosRespuestaTopico(Long id, String titulo, String mensaje, DatosCurso curso,
                                   LocalDateTime fechaCreacion, DatosUsuario autor, List<Respuesta> respuestas) {
}
