package br.com.rafadev.gestao_servidores_api.domain.dto.request;

import br.com.rafadev.gestao_servidores_api.domain.enums.StatusEspecializacao;
import br.com.rafadev.gestao_servidores_api.domain.enums.TipoEspecializacao;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record EspecializacaoUpdate(

        String area,
        TipoEspecializacao tipoEspecializacao,
        Integer cargaHoraria,
        BigDecimal valorTotal,
        StatusEspecializacao status,
        String motivoIndeferimento
) {
}
