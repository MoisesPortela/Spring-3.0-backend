package com.api.study.domain.consulta.validacoes;

import com.api.study.domain.consulta.DadosAgendarConsulta;
import com.api.study.infra.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component
public class ValidadorHorarioFuncionamento implements ValidarAgendamentoConsulta{

    public void validar(DadosAgendarConsulta dados){
        var dataConsulta =dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dataConsulta.getHour()<7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour()>18;
        if(domingo||antesDaAbertura||depoisDoEncerramentoDaClinica){
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica!");
        }
    }
}
