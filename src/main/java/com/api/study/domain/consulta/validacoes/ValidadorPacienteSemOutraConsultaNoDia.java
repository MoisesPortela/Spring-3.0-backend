package com.api.study.domain.consulta.validacoes;

import com.api.study.domain.consulta.ConsultaRepository;
import com.api.study.domain.consulta.DadosAgendarConsulta;
import com.api.study.infra.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidarAgendamentoConsulta{
    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendarConsulta dadosAgendarConsulta){
        var primeiroHorario = dadosAgendarConsulta.data().withHour(7);
        var ultimoHorario = dadosAgendarConsulta.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = consultaRepository.existsByPacienteIdAndDataBetween(dadosAgendarConsulta.idPaciente(),
                primeiroHorario,ultimoHorario);
        if (pacientePossuiOutraConsultaNoDia){
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia!");
        }
    }
}
