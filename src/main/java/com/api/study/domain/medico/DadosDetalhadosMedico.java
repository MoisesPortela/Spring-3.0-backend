package com.api.study.domain.medico;

import com.api.study.domain.endereco.Endereco;

public record DadosDetalhadosMedico(Long id, String nome, String telefone, String email, String crm, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhadosMedico(Medico medico){
        this(medico.getId(),medico.getNome(), medico.getTelefone(),
                medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco() );
    }
}
