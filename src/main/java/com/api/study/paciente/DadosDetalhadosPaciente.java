package com.api.study.paciente;

import com.api.study.endereco.Endereco;

public record DadosDetalhadosPaciente(Long id, String nome, String telefone, Endereco endereco) {

    public DadosDetalhadosPaciente(Paciente paciente){
        this(paciente.getId(),
                paciente.getNome(),
                paciente.getTelefone(),
                paciente.getEndereco());
    }


}
