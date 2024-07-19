package br.com.rafadev.gestao_servidores_api.service.mapper;

import br.com.rafadev.gestao_servidores_api.domain.dto.request.ServidorCreate;
import br.com.rafadev.gestao_servidores_api.domain.dto.request.ServidorUpdate;
import br.com.rafadev.gestao_servidores_api.domain.dto.response.ServidorResponse;
import br.com.rafadev.gestao_servidores_api.domain.model.Especializacao;
import br.com.rafadev.gestao_servidores_api.domain.model.Servidor;
import br.com.rafadev.gestao_servidores_api.service.EspecializacaoService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class ServidorMapper {

    private final EspecializacaoService especializacaoService;

    public ServidorMapper(EspecializacaoService especializacaoService) {
        this.especializacaoService = especializacaoService;
    }

    public Servidor toEntity(ServidorCreate servidorCreate) {
        return Servidor.builder()
                .cpf(servidorCreate.cpf())
                .email(servidorCreate.email())
                .matricula(servidorCreate.matricula())
                .nome(servidorCreate.nome())
                .dataNascimento(servidorCreate.dataNascimento())
                .sexo(servidorCreate.sexo())
                .tipoServidor(servidorCreate.tipoServidor())
                .build();
    }

    public void updateEntity(ServidorUpdate servidorUpdate, Servidor servidor) {
        if (Objects.nonNull(servidorUpdate.cpf())) {
            servidor.setCpf(servidorUpdate.cpf());
        }
        if (Objects.nonNull(servidorUpdate.email())) {
            servidor.setEmail(servidorUpdate.email());
        }
        if (Objects.nonNull(servidorUpdate.matricula())) {
            servidor.setMatricula(servidorUpdate.matricula());
        }
        if (Objects.nonNull(servidorUpdate.nome())) {
            servidor.setNome(servidorUpdate.nome());
        }
        if (Objects.nonNull(servidorUpdate.dataNascimento())) {
            servidor.setDataNascimento(servidorUpdate.dataNascimento());
        }
        if (Objects.nonNull(servidorUpdate.sexo())) {
            servidor.setSexo(servidorUpdate.sexo());
        }
        if (Objects.nonNull(servidorUpdate.tipoServidor())) {
            servidor.setTipoServidor(servidorUpdate.tipoServidor());
        }
    }

    public ServidorResponse toDTO(Servidor servidor) {
        List<Especializacao> especializacoes = especializacaoService.findAllByServidor(servidor);

        return new ServidorResponse(
                servidor.getId(),
                servidor.getCpf(),
                servidor.getEmail(),
                servidor.getMatricula(),
                servidor.getNome(),
                servidor.getDataNascimento(),
                servidor.getSexo(),
                servidor.getTipoServidor(),
                especializacoes
        );
    }
}
