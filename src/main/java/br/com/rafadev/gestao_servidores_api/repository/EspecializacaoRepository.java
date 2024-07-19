package br.com.rafadev.gestao_servidores_api.repository;

import br.com.rafadev.gestao_servidores_api.domain.model.Especializacao;
import br.com.rafadev.gestao_servidores_api.domain.model.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspecializacaoRepository extends JpaRepository<Especializacao, Long> {
    List<Especializacao> findAllByServidor(Servidor servidor);
}
