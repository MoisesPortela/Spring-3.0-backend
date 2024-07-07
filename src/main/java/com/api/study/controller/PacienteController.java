package com.api.study.controller;

import com.api.study.paciente.DadosCadastroPaciente;
import com.api.study.paciente.Paciente;
import com.api.study.paciente.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroPaciente dadosPaciente){
        pacienteRepository.save(new Paciente(dadosPaciente));
    }
}
