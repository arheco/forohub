package com.arheco.apialu.controller;

import com.arheco.apialu.model.DatosListadoTopico;
import com.arheco.apialu.model.DatosRegistroTopico;
import com.arheco.apialu.model.Topico;
import com.arheco.apialu.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tópicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity<Topico> registrar(
            @RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {

        Topico topicoGuardado = topicoService.registrarTopico(datosRegistroTopico);
        return ResponseEntity.ok(topicoGuardado);
    }

    @GetMapping
    public ResponseEntity<List<DatosListadoTopico>> listar() {
        List<DatosListadoTopico> listado = topicoService.listarTopicos();
        return ResponseEntity.ok(listado);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DatosListadoTopico> detallar(@PathVariable Long id) {
        DatosListadoTopico detalle = topicoService.detallarTopico(id);
        return ResponseEntity.ok(detalle);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }

}