package br.com.rafadev.gestao_servidores_api.service;

import br.com.rafadev.gestao_servidores_api.domain.model.Servidor;
import br.com.rafadev.gestao_servidores_api.exception.ResourceNotFoundException;
import br.com.rafadev.gestao_servidores_api.repository.ServidorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServidorService {

    private final ServidorRepository servidorRepository;

    public ServidorService(ServidorRepository servidorRepository) {
        this.servidorRepository = servidorRepository;
    }

    public Servidor save(Servidor servidor) {
        return servidorRepository.save(servidor);
    }

    public List<Servidor> findAll() {
        return servidorRepository.findAll();
    }

    public Servidor findById(Long id) {

        return servidorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Servidor não encontrado."));
    }

    public void delete(Long id) {

        Optional<Servidor> servidorOptional = servidorRepository.findById(id);

        if (servidorOptional.isEmpty()) {
            throw new ResourceNotFoundException("Servidor não encontrado");
        }

        servidorRepository.delete(servidorOptional.get());
    }
}
