package com.api.study.domain.consulta;

import com.api.study.domain.consulta.validacoes.ValidarAgendamentoConsulta;
import com.api.study.domain.medico.Medico;
import com.api.study.domain.medico.MedicoRepository;
import com.api.study.domain.paciente.PacienteRepository;
import com.api.study.infra.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private List<ValidarAgendamentoConsulta> valodadores;

    public DadosDetalhamentoConsulta agendar(DadosAgendarConsulta dadosAgendarConsulta){
        if (!pacienteRepository.existsById(dadosAgendarConsulta.idPaciente())){
            throw new ValidacaoException("Id do paciente informado não existe");
        }
        if(dadosAgendarConsulta.idMedico()!= null && !medicoRepository.existsById(dadosAgendarConsulta.idMedico())){
            throw new ValidacaoException("Id do medico informado não existe");
        }

        valodadores.forEach(v ->v.validar(dadosAgendarConsulta));

        var medico = escolherMedico(dadosAgendarConsulta);
        if (medico==null){
            throw new ValidacaoException("Não existe médico disponível nessa data!");
        }
        var paciente = pacienteRepository.getReferenceById(dadosAgendarConsulta.idPaciente());
        var consulta = new Consulta(null,medico,paciente,dadosAgendarConsulta.data(),null);
        consultaRepository.save(consulta);
        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendarConsulta dadosAgendarConsulta) {
        if(dadosAgendarConsulta.idMedico()!=null) {
            return medicoRepository.getReferenceById(dadosAgendarConsulta.idMedico());
        }
        if(dadosAgendarConsulta.especialidade()==null){
            throw new ValidacaoException("Especialidade é obrigatória quando o médico não for escolhido");
        }
        return medicoRepository.escolherMedicoAleatorioLivreNaData(dadosAgendarConsulta.especialidade(),dadosAgendarConsulta.data());
    }
    public void cancelar(DadosCancelarConsulta dados){
        if (!consultaRepository.existsById(dados.idConsulta())){
            throw new ValidacaoException("Id da consulta informado não existe");
        }
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }
}
