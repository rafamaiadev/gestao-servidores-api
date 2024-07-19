package br.com.rafadev.gestao_servidores_api.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Email {

    APROVADA("Solicitação de Especialização Aprovada", "Parabéns,sua solicitação de especialização foi aprovada!"),
    REPROVADA("Solicitação de Especialização Reprovada", "Sua solicitação de especialização foi reprovada. Motivo: ");

    private String subject;
    private String text;
}
