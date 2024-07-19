package br.com.rafadev.gestao_servidores_api.domain.dto.response;

import br.com.rafadev.gestao_servidores_api.domain.enums.StatusEspecializacao;
import br.com.rafadev.gestao_servidores_api.domain.enums.TipoEspecializacao;
import br.com.rafadev.gestao_servidores_api.domain.model.Servidor;
import lombok.Builder;

import java.math.BigDecimal;


@Builder
public record EspecializacaoResponse(
        Long id,
        String area,
        TipoEspecializacao tipoEspecializacao, // Pós-Graduação, Doutorado, Mestrado
        Integer cargaHoraria,
        BigDecimal valorTotal,
        StatusEspecializacao status, // Enum representando o status
        String motivoIndeferimento,
        Servidor servidor
) {
}
