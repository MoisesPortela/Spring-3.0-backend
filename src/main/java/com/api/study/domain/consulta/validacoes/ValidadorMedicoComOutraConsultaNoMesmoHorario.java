package com.api.study.domain.consulta.validacoes;

import com.api.study.domain.consulta.ConsultaRepository;
import com.api.study.domain.consulta.DadosAgendarConsulta;
import com.api.study.infra.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidarAgendamentoConsulta{
    @Autowired
    private ConsultaRepository consultaRepository;


    public void validar(DadosAgendarConsulta dadosAgendarConsulta){
        var medicoPossuiOutraConsultaNoMesmoHorario = consultaRepository.existsByMedicoIdAndData(dadosAgendarConsulta.idMedico(),dadosAgendarConsulta.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse horário!");
        }
    }
}
