package br.com.rafadev.gestao_servidores_api.controller;

import br.com.rafadev.gestao_servidores_api.domain.dto.request.ServidorCreate;
import br.com.rafadev.gestao_servidores_api.domain.dto.request.ServidorUpdate;
import br.com.rafadev.gestao_servidores_api.domain.dto.response.ServidorResponse;
import br.com.rafadev.gestao_servidores_api.domain.model.Servidor;
import br.com.rafadev.gestao_servidores_api.repository.ServidorRepository;
import br.com.rafadev.gestao_servidores_api.service.impl.ServidorServiceImpl;
import br.com.rafadev.gestao_servidores_api.service.mapper.ServidorMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servidores")
public class ServidorController {

    private final ServidorServiceImpl servidorServiceImpl;
    private final ServidorMapper servidorMapper;
    private final ServidorRepository servidorRepository;

    public ServidorController(ServidorServiceImpl servidorServiceImpl, ServidorMapper servidorMapper, ServidorRepository servidorRepository) {
        this.servidorServiceImpl = servidorServiceImpl;
        this.servidorMapper = servidorMapper;
        this.servidorRepository = servidorRepository;
    }

    @PostMapping
    public ResponseEntity<ServidorResponse> create(@RequestBody @Valid ServidorCreate servidorCreate) {

        Servidor servidor = servidorMapper.toEntity(servidorCreate);
        servidorServiceImpl.save(servidor);
        ServidorResponse servidorResponse = servidorMapper.toDTO(servidor);

        return ResponseEntity.status(HttpStatus.CREATED).body(servidorResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServidorResponse> update(@PathVariable Long id,@RequestBody ServidorUpdate servidorUpdate) {
        Servidor servidor = servidorServiceImpl.findById(id);

        servidorMapper.updateEntity(servidorUpdate, servidor);

        servidorRepository.save(servidor);

        ServidorResponse servidorResponse = servidorMapper.toDTO(servidor);

        return ResponseEntity.status(HttpStatus.OK).body(servidorResponse);
    }

    @GetMapping
    public ResponseEntity<List<ServidorResponse>> findAll() {

        List<Servidor> servidores =  servidorServiceImpl.findAll();
        List<ServidorResponse> servidoresResponse = servidores.stream()
                .map(servidorMapper::toDTO)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(servidoresResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

        servidorServiceImpl.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
