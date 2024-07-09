package com.api.study.domain.consulta.validacoes;

import com.api.study.domain.consulta.DadosAgendarConsulta;
import com.api.study.domain.paciente.PacienteRepository;
import com.api.study.infra.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidarAgendamentoConsulta{
    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DadosAgendarConsulta dadosAgendarConsulta){
        var pacienteAtivo= pacienteRepository.findAtivoById(dadosAgendarConsulta.idPaciente());
        if (!pacienteAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluido");
        }
    }
}
