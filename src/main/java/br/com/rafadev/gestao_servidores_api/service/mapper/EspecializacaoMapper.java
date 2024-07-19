package br.com.rafadev.gestao_servidores_api.service.mapper;

import br.com.rafadev.gestao_servidores_api.domain.dto.request.EspecializacaoCreate;
import br.com.rafadev.gestao_servidores_api.domain.dto.request.EspecializacaoUpdate;
import br.com.rafadev.gestao_servidores_api.domain.dto.response.EspecializacaoResponse;
import br.com.rafadev.gestao_servidores_api.domain.enums.StatusEspecializacao;
import br.com.rafadev.gestao_servidores_api.domain.model.Especializacao;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EspecializacaoMapper {

    public Especializacao toEntity(EspecializacaoCreate especializacaoCreate) {
        return Especializacao.builder()
                .area(especializacaoCreate.area().trim())
                .tipoEspecializacao(especializacaoCreate.tipoEspecializacao())
                .cargaHoraria(especializacaoCreate.cargaHoraria())
                .valorTotal(especializacaoCreate.valorTotal())
                .status(StatusEspecializacao.PENDENTE)
                .build();
    }

    public void updateEntity(EspecializacaoUpdate especializacaoUpdate, Especializacao especializacao) {
        if (Objects.nonNull(especializacaoUpdate.area())) {
            especializacao.setArea(especializacaoUpdate.area().trim());
        }
        if (Objects.nonNull(especializacaoUpdate.tipoEspecializacao())) {
            especializacao.setTipoEspecializacao(especializacaoUpdate.tipoEspecializacao());
        }
        if (Objects.nonNull(especializacaoUpdate.cargaHoraria())) {
            especializacao.setCargaHoraria(especializacaoUpdate.cargaHoraria());
        }
        if (Objects.nonNull(especializacaoUpdate.valorTotal())) {
            especializacao.setValorTotal(especializacaoUpdate.valorTotal());
        }
        if (Objects.nonNull(especializacaoUpdate.status())) {
            especializacao.setStatus(especializacaoUpdate.status());
        }
        if (Objects.nonNull(especializacaoUpdate.motivoIndeferimento())) {
            especializacao.setMotivoIndeferimento(especializacaoUpdate.motivoIndeferimento());
        }
    }

    public EspecializacaoResponse toDTO(Especializacao especializacao) {
        return new EspecializacaoResponse(
                especializacao.getId(),
                especializacao.getArea(),
                especializacao.getTipoEspecializacao(),
                especializacao.getCargaHoraria(),
                especializacao.getValorTotal(),
                especializacao.getStatus(),
                especializacao.getMotivoIndeferimento(),
                especializacao.getServidor()
        );
    }
}
