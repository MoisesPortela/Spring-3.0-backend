package com.api.study.controller;

import com.api.study.paciente.DadosCadastroPaciente;
import com.api.study.paciente.DadosListagemPaciente;
import com.api.study.paciente.Paciente;
import com.api.study.paciente.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<DadosListagemPaciente> findAll(@PageableDefault(size = 10, sort = "nome") Pageable pageable){
        return pacienteRepository.findAll(pageable).map(DadosListagemPaciente :: new);
    }
}
