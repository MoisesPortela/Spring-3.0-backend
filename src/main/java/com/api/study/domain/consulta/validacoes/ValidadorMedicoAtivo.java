package com.api.study.domain.consulta.validacoes;

import com.api.study.domain.consulta.DadosAgendarConsulta;
import com.api.study.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidarAgendamentoConsulta {
    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendarConsulta dadosAgendarConsulta){
        if(dadosAgendarConsulta.idMedico()==null){
            return;
        }
        var medicoEstaAtivo = medicoRepository.findAtivoById(dadosAgendarConsulta.idMedico());
    }
}
