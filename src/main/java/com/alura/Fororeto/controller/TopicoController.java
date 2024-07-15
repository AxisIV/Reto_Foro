package com.alura.Fororeto.controller;

import com.alura.Fororeto.domain.Topico.*;
import com.alura.Fororeto.domain.Usuarios.DatosUsuario;
import com.alura.Fororeto.domain.curso.DatosCurso;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoRepository repository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = repository.save(new Topico(datosRegistroTopico));

        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(),
                new DatosCurso(topico.getCurso().getNombre(), topico.getCurso().getCategoria()),
                topico.getFechaCreacion(), new DatosUsuario(topico.getAutor().getNombre()), topico.getRespuestas()
        );

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaTopico>> listarTopicos(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(repository.findAll(paginacion).map(topico ->
                new DatosRespuestaTopico(
                        topico.getId(), topico.getTitulo(), topico.getMensaje(),
                        new DatosCurso(topico.getCurso().getNombre(), topico.getCurso().getCategoria()),
                        topico.getFechaCreacion(), new DatosUsuario(topico.getAutor().getNombre()), topico.getRespuestas()
                )
        ));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@RequestBody @Valid DatosActualizacionTopico datosActualizacionTopico) {
        Topico topico = repository.getReferenceById(datosActualizacionTopico.id());
        topico.setTitulo(datosActualizacionTopico.titulo());
        topico.setMensaje(datosActualizacionTopico.mensaje());
        topico.setCurso(datosActualizacionTopico.curso());
        topico.setAutor(datosActualizacionTopico.autor());

        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(),
                new DatosCurso(topico.getCurso().getNombre(), topico.getCurso().getCategoria()),
                topico.getFechaCreacion(), new DatosUsuario(topico.getAutor().getNombre()), topico.getRespuestas()
        );
        return ResponseEntity.ok(datosRespuestaTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        Topico topico = repository.getReferenceById(id);
        repository.delete(topico);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> obtenerTopicoPorId(@PathVariable Long id) {
        Topico topico = repository.getReferenceById(id);
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(),
                new DatosCurso(topico.getCurso().getNombre(), topico.getCurso().getCategoria()),
                topico.getFechaCreacion(), new DatosUsuario(topico.getAutor().getNombre()), topico.getRespuestas()
        );
        return ResponseEntity.ok(datosRespuestaTopico);
    }
}
