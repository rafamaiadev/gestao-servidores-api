package br.com.rafadev.gestao_servidores_api.domain.enums;

import lombok.Getter;

@Getter
public enum TipoEspecializacao {

    POS_GRADUACAO("Pós-Graduação"),
    DOUTORADO("Doutorado"),
    MESTRADO("Mestrado");

    private String descricao;

    TipoEspecializacao(String descricao) {
        this.descricao = descricao;
    }
}
