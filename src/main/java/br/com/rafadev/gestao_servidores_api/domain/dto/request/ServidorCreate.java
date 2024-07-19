package br.com.rafadev.gestao_servidores_api.domain.dto.request;

import br.com.rafadev.gestao_servidores_api.domain.enums.TipoServidor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Builder
public record ServidorCreate(

        @CPF
        @NotEmpty
        String cpf,

        @NotEmpty
        @Email
        String email,

        @NotEmpty
        String matricula,

        @NotEmpty
        String nome,

        @NotNull
        LocalDate dataNascimento,

        @NotEmpty
        String sexo,

        @NotNull
        TipoServidor tipoServidor
) {
}