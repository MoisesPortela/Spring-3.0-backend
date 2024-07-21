package com.api.study.domain.medico;

import com.api.study.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="medicos")
@Entity(name="Medico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(DadosCadastroMedico dadosMedico) {
        this.ativo=true;
        this.nome= dadosMedico.nome();
        this.email= dadosMedico.email();
        this.telefone= dadosMedico.telefone();
        this.crm= dadosMedico.crm();
        this.especialidade=dadosMedico.especialidade();
        this.endereco= new Endereco(dadosMedico.endereco());
    }

    public void atualizarMedico(DadosAtualizarMedico dadosAtualizarMedico) {
        if(dadosAtualizarMedico.nome()!=null){
            this.nome= dadosAtualizarMedico.nome();
        }
        if(dadosAtualizarMedico.telefone()!=null){
            this.telefone= dadosAtualizarMedico.telefone();
        }
        if(dadosAtualizarMedico.endereco()!=null){
            this.endereco.atualizarEndereco(dadosAtualizarMedico.endereco());
        }
    }

    public void excluir() {
        this.ativo=false;
    }
}
