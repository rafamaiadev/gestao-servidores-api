package br.com.rafadev.gestao_servidores_api.service;

import br.com.rafadev.gestao_servidores_api.domain.model.Servidor;
import br.com.rafadev.gestao_servidores_api.exception.ResourceNotFoundException;

import java.util.List;

public interface ServidorService {

    Servidor save(Servidor servidor);

    List<Servidor> findAll();

    Servidor findById(Long id) throws ResourceNotFoundException;

    void delete(Long id) throws ResourceNotFoundException;
}

