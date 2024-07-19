package br.com.rafadev.gestao_servidores_api.domain.dto.request;

import br.com.rafadev.gestao_servidores_api.domain.enums.TipoServidor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Builder
public record ServidorUpdate(
        @Email
        String email,

        @CPF
        @NotEmpty
        String cpf,

        String matricula,

        String nome,

        LocalDate dataNascimento,

        String sexo,

        TipoServidor tipoServidor
) {
}
