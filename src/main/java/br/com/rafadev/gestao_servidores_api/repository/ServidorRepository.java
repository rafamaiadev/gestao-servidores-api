package br.com.rafadev.gestao_servidores_api.repository;

import br.com.rafadev.gestao_servidores_api.domain.model.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor, Long> {
}
