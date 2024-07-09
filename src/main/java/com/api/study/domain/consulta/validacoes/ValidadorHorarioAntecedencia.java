package com.api.study.domain.consulta.validacoes;

import com.api.study.domain.consulta.DadosAgendarConsulta;
import com.api.study.infra.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidarAgendamentoConsulta{

    public void validar(DadosAgendarConsulta dadosAgendarConsulta){
        var agora = LocalTime.now();
        var horarioConsulta = dadosAgendarConsulta.data();
        var diferencaEmMinutos = Duration.between(agora,horarioConsulta).toMinutes();
        if (diferencaEmMinutos<30){
            throw new ValidacaoException("Consulta deve ser agendada com antecedência mínima de 30 minutos!");
        }
    }
}
