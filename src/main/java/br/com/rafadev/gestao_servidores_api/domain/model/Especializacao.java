package br.com.rafadev.gestao_servidores_api.domain.model;

import br.com.rafadev.gestao_servidores_api.domain.enums.StatusEspecializacao;
import br.com.rafadev.gestao_servidores_api.domain.enums.TipoEspecializacao;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Especializacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "area", nullable = false)
    private String area;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_especializacao", nullable = false)
    private TipoEspecializacao tipoEspecializacao;

    @Column(name = "carga_horaria", nullable = false)
    private Integer cargaHoraria;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "servidor_id", nullable = false)
    private Servidor servidor;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "status")
    private StatusEspecializacao status;

    @JoinColumn(name = "motivo_indeferimento")
    private String motivoIndeferimento;
}
