package br.com.rafadev.gestao_servidores_api.domain.enums;

import lombok.Getter;

@Getter
public enum StatusEspecializacao {

    APROVADO("Aprovado"),
    REPROVADO("Reprovado"),
    PENDENTE("PENDENTE");

    private String descricao;

    StatusEspecializacao(String descricao) {
        this.descricao = descricao;
    }
}
