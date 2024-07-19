package br.com.rafadev.gestao_servidores_api.domain.dto.request;

import br.com.rafadev.gestao_servidores_api.domain.enums.TipoEspecializacao;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record EspecializacaoCreate(

        @NotEmpty
        String area,

        @NotNull
        TipoEspecializacao tipoEspecializacao,

        @NotNull
        Integer cargaHoraria,

        @NotNull
        BigDecimal valorTotal,

        @NotNull
        Long servidorId
) {
}
