package br.com.rafadev.gestao_servidores_api.service;

import br.com.rafadev.gestao_servidores_api.domain.model.Especializacao;
import br.com.rafadev.gestao_servidores_api.domain.model.Servidor;
import br.com.rafadev.gestao_servidores_api.exception.ResourceNotFoundException;

import java.util.List;

public interface EspecializacaoService {

    Especializacao save(Especializacao especializacao);

    void delete(Long id) throws ResourceNotFoundException;

    List<Especializacao> findAll();

    List<Especializacao> findAllByServidor(Servidor servidor);

    Especializacao aprovarEspecializacao(Long id) throws ResourceNotFoundException;

    Especializacao reprovarEspecializacao(Long id, String motivo) throws ResourceNotFoundException;

    Especializacao findById(Long id) throws ResourceNotFoundException;
}

