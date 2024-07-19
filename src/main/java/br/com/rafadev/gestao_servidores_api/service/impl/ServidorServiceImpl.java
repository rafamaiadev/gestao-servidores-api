package br.com.rafadev.gestao_servidores_api.service.impl;

import br.com.rafadev.gestao_servidores_api.domain.model.Servidor;
import br.com.rafadev.gestao_servidores_api.exception.ResourceNotFoundException;
import br.com.rafadev.gestao_servidores_api.repository.ServidorRepository;
import br.com.rafadev.gestao_servidores_api.service.ServidorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServidorServiceImpl implements ServidorService {

    private final ServidorRepository servidorRepository;

    public ServidorServiceImpl(ServidorRepository servidorRepository) {
        this.servidorRepository = servidorRepository;
    }

    @Override
    public Servidor save(Servidor servidor) {
        return servidorRepository.save(servidor);
    }

    @Override
    public List<Servidor> findAll() {
        return servidorRepository.findAll();
    }

    @Override
    public Servidor findById(Long id) {

        return servidorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Servidor não encontrado."));
    }

    @Override
    public void delete(Long id) {

        Optional<Servidor> servidorOptional = servidorRepository.findById(id);

        if (servidorOptional.isEmpty()) {
            throw new ResourceNotFoundException("Servidor não encontrado");
        }

        servidorRepository.delete(servidorOptional.get());
    }
}
