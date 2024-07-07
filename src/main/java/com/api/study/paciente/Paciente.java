package com.api.study.paciente;

import com.api.study.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dadosPaciente) {
        this.nome= dadosPaciente.nome();
        this.email= dadosPaciente.email();
        this.telefone= dadosPaciente.telefone();
        this.cpf= dadosPaciente.cpf();
        this.endereco= new Endereco(dadosPaciente.endereco());
    }
}
