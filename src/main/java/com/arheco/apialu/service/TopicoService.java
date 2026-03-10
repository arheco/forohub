package com.arheco.apialu.service;

import com.arheco.apialu.model.DatosListadoTopico;
import com.arheco.apialu.model.DatosRegistroTopico;
import com.arheco.apialu.model.Topico;
import com.arheco.apialu.repository.TopicoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public Topico registrarTopico(DatosRegistroTopico datos) {
        if (topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje");
        }

        Topico nuevoTopico = new Topico(
                null,
                datos.titulo(),
                datos.mensaje(),
                LocalDateTime.now(),
                "ACTIVO",
                datos.autor(),
                datos.curso()
        );

        return topicoRepository.save(nuevoTopico);
    }

    public List<DatosListadoTopico> listarTopicos() {
        return topicoRepository.findAll().stream()
                .map(DatosListadoTopico::new)
                .collect(Collectors.toList());
    }

    public DatosListadoTopico detallarTopico(Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado con el ID proporcionado"));

        return new DatosListadoTopico(topico);
    }


    public void eliminarTopico(Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);

        if (topicoOptional.isPresent()) {
            topicoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El tópico con el ID proporcionado no existe");
        }
    }


}