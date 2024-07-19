package br.com.rafadev.gestao_servidores_api.domain.enums;

import lombok.Getter;

@Getter
public enum TipoServidor {

    PROFESSOR("Professor"),
    TECNICO("Técnico");

    private String descricao;

    TipoServidor(String descricao) {
        this.descricao = descricao;
    }
}
