package com.api.study.medico;

public record DadosDetalhadosMedico(Long id,String nome,String telefone, String email, String crm, Especialidade especialidade) {

    public DadosDetalhadosMedico(Medico medico){
        this(medico.getId(),medico.getNome(), medico.getTelefone(),
                medico.getEmail(), medico.getCrm(), medico.getEspecialidade() );
    }
}
