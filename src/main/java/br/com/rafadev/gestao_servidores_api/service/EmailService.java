package br.com.rafadev.gestao_servidores_api.service;

public interface EmailService {

    void sendMessage(String to, String subject, String text);
}
