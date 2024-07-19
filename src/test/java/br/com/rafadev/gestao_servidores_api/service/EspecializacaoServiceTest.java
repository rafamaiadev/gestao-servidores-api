package br.com.rafadev.gestao_servidores_api.service;

import br.com.rafadev.gestao_servidores_api.domain.enums.Email;
import br.com.rafadev.gestao_servidores_api.domain.enums.StatusEspecializacao;
import br.com.rafadev.gestao_servidores_api.domain.model.Especializacao;
import br.com.rafadev.gestao_servidores_api.domain.model.Servidor;
import br.com.rafadev.gestao_servidores_api.repository.EspecializacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EspecializacaoServiceTest {

    @Mock
    private EspecializacaoRepository especializacaoRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private EspecializacaoService especializacaoService;

    private Especializacao especializacao;

    private Servidor servidor;

    @BeforeEach
    public void setUp() {
        servidor = new Servidor();
        servidor.setEmail("servidor@example.com");

        especializacao = new Especializacao();
        especializacao.setId(1L);
        especializacao.setServidor(servidor);
    }

    @Test
    public void deveAprovarEspecialização() {
        when(especializacaoRepository.findById(1L)).thenReturn(Optional.of(especializacao));
        when(especializacaoRepository.save(especializacao)).thenReturn(especializacao);

        Especializacao result = especializacaoService.aprovarEspecializacao(1L);

        assertEquals(StatusEspecializacao.APROVADO, result.getStatus());

        verify(especializacaoRepository, times(1)).save(result);
        verify(emailService, times(1)).sendMessage(
                eq(servidor.getEmail()),
                eq(Email.APROVADA.getSubject()),
                eq(Email.APROVADA.getText())
        );
    }

    @Test
    public void deveReprovarEspecializacao() {

        String motivo = "Os requisitos mínimos não foram atendidos.";

        when(especializacaoRepository.findById(1L)).thenReturn(Optional.of(especializacao));
        when(especializacaoRepository.save(especializacao)).thenReturn(especializacao);

        Especializacao result = especializacaoService.reprovarEspecializacao(1L, motivo);

        assertEquals(StatusEspecializacao.REPROVADO, result.getStatus());
        assertEquals(motivo, result.getMotivoIndeferimento());

        verify(especializacaoRepository, times(1)).save(result);
        verify(emailService, times(1)).sendMessage(
                eq(servidor.getEmail()),
                eq(Email.REPROVADA.getSubject()),
                eq(Email.REPROVADA.getText() + motivo)
        );
    }
}

