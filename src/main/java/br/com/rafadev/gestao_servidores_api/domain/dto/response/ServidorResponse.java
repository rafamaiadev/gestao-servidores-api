package br.com.rafadev.gestao_servidores_api.domain.dto.response;

import br.com.rafadev.gestao_servidores_api.domain.enums.TipoServidor;
import br.com.rafadev.gestao_servidores_api.domain.model.Especializacao;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record ServidorResponse(
        Long id,
        String cpf,
        String email,
        String matricula,
        String nome,
        LocalDate dataNascimento,
        String sexo,
        TipoServidor tipoServidor,
        List<Especializacao> especializacoes
) {
}
