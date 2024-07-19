package br.com.rafadev.gestao_servidores_api.domain.model;

import br.com.rafadev.gestao_servidores_api.domain.enums.TipoServidor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Servidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "matricula", nullable = false)
    private String matricula;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "tipo_servidor", nullable = false)
    private TipoServidor tipoServidor;

    @JsonIgnore
    @Transient
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "servidor", cascade = CascadeType.REMOVE)
    List<Especializacao> especializacoes;
}
