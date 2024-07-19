package br.com.rafadev.gestao_servidores_api.controller;

import br.com.rafadev.gestao_servidores_api.domain.dto.request.EspecializacaoCreate;
import br.com.rafadev.gestao_servidores_api.domain.dto.request.EspecializacaoUpdate;
import br.com.rafadev.gestao_servidores_api.domain.dto.response.EspecializacaoResponse;
import br.com.rafadev.gestao_servidores_api.domain.model.Especializacao;
import br.com.rafadev.gestao_servidores_api.domain.model.Servidor;
import br.com.rafadev.gestao_servidores_api.service.EspecializacaoService;
import br.com.rafadev.gestao_servidores_api.service.ServidorService;
import br.com.rafadev.gestao_servidores_api.service.mapper.EspecializacaoMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/especializacoes")
public class EspecializacaoController {

    private final EspecializacaoService especializacaoService;
    private final ServidorService servidorService;
    private final EspecializacaoMapper especializacaoMapper;

    public EspecializacaoController(EspecializacaoService especializacaoService, ServidorService servidorService, EspecializacaoMapper especializacaoMapper) {
        this.especializacaoService = especializacaoService;
        this.servidorService = servidorService;
        this.especializacaoMapper = especializacaoMapper;
    }

    @PostMapping
    public ResponseEntity<EspecializacaoResponse> save(@RequestBody @Valid EspecializacaoCreate especializacaoCreate) {

        Servidor servidor = servidorService.findById(especializacaoCreate.servidorId());

        Especializacao especializacao = especializacaoMapper.toEntity(especializacaoCreate);
        especializacao.setServidor(servidor);

        especializacaoService.save(especializacao);

        EspecializacaoResponse especializacaoResponse = especializacaoMapper.toDTO(especializacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(especializacaoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecializacaoResponse> update(@PathVariable("id") Long id, @RequestBody @Valid EspecializacaoUpdate especializacaoUpdate) {

        Especializacao especializacao = especializacaoService.findById(id);

        especializacaoMapper.updateEntity(especializacaoUpdate, especializacao);

        especializacaoService.save(especializacao);

        EspecializacaoResponse especializacaoResponse = especializacaoMapper.toDTO(especializacao);
        return ResponseEntity.status(HttpStatus.OK).body(especializacaoResponse);
    }

    @GetMapping
    public ResponseEntity<List<EspecializacaoResponse>> findAll() {

        List<Especializacao> especializacoes = especializacaoService.findAll();

        List<EspecializacaoResponse> especializacoesResponse = especializacoes.stream()
                .map(especializacaoMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(especializacoesResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecializacao(@PathVariable("id") Long id) {

        especializacaoService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}/aprovar")
    public ResponseEntity<EspecializacaoResponse> aprovarEspecializacao(@PathVariable("id") Long id) {

        Especializacao especializacao = especializacaoService.aprovarEspecializacao(id);

        EspecializacaoResponse especializacaoResponse = especializacaoMapper.toDTO(especializacao);

        return ResponseEntity.status(HttpStatus.OK).body(especializacaoResponse);
    }

    @PutMapping("/{id}/reprovar")
    public ResponseEntity<EspecializacaoResponse> indeferirEspecializacao(@PathVariable("id") Long id, @RequestBody String motivo) {

        Especializacao especializacao = especializacaoService.reprovarEspecializacao(id, motivo);

        EspecializacaoResponse especializacaoResponse = especializacaoMapper.toDTO(especializacao);

        return ResponseEntity.status(HttpStatus.OK).body(especializacaoResponse);
    }
}
