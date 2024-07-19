package br.com.rafadev.gestao_servidores_api.service.impl;

import br.com.rafadev.gestao_servidores_api.domain.enums.Email;
import br.com.rafadev.gestao_servidores_api.domain.enums.StatusEspecializacao;
import br.com.rafadev.gestao_servidores_api.domain.model.Especializacao;
import br.com.rafadev.gestao_servidores_api.domain.model.Servidor;
import br.com.rafadev.gestao_servidores_api.exception.ResourceNotFoundException;
import br.com.rafadev.gestao_servidores_api.repository.EspecializacaoRepository;
import br.com.rafadev.gestao_servidores_api.service.EmailService;
import br.com.rafadev.gestao_servidores_api.service.EspecializacaoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.rafadev.gestao_servidores_api.domain.enums.Email.APROVADA;

@Service
public class EspecializacaoServiceImpl implements EspecializacaoService {

    private final EspecializacaoRepository especializacaoRepository;

    private final EmailService emailService;

    public EspecializacaoServiceImpl(EspecializacaoRepository especializacaoRepository, EmailService emailService) {
        this.especializacaoRepository = especializacaoRepository;
        this.emailService = emailService;
    }

    @Override
    public Especializacao save(Especializacao especializacao) {
        return especializacaoRepository.save(especializacao);
    }

    @Override
    public void delete(Long id) {
        Optional<Especializacao> especializacaoOptional = especializacaoRepository.findById(id);

        if (especializacaoOptional.isEmpty()) {
            throw new ResourceNotFoundException("Especialização não encontrada");
        }

        especializacaoRepository.delete(especializacaoOptional.get());
    }

    //TODO: refatorar para retornar uma coleção Page.
    @Override
    public List<Especializacao> findAll() {
        return especializacaoRepository.findAll();
    }

    public List<Especializacao> findAllByServidor(Servidor servidor) {

        return especializacaoRepository.findAllByServidor(servidor);
    }

    @Override
    public Especializacao aprovarEspecializacao(Long id) {

        Especializacao especializacao = findById(id);

        especializacao.setStatus(StatusEspecializacao.APROVADO);

        especializacaoRepository.save(especializacao);

        emailService.sendMessage(especializacao.getServidor().getEmail(), Email.APROVADA.getSubject(), APROVADA.getText());

        return especializacao;
    }

    @Override
    public Especializacao reprovarEspecializacao(Long id, String motivo) {

        Especializacao especializacao = findById(id);

        especializacao.setStatus(StatusEspecializacao.REPROVADO);
        especializacao.setMotivoIndeferimento(motivo);

        especializacaoRepository.save(especializacao);

        emailService.sendMessage(especializacao.getServidor().getEmail(), Email.REPROVADA.getSubject(), Email.REPROVADA.getText() + motivo);

        return especializacao;
    }

    @Override
    public Especializacao findById(Long id) {

        return especializacaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Especialização não encontrada."));
    }
}
