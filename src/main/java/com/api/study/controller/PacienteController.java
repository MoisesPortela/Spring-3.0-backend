package com.api.study.controller;

import com.api.study.paciente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dadosPaciente){
        pacienteRepository.save(new Paciente(dadosPaciente));
    }

    @GetMapping
    public Page<DadosListagemPaciente> findAll(@PageableDefault(size = 10, sort = "nome") Pageable pageable){
        return pacienteRepository.findAllByAtivoTrue(pageable).map(DadosListagemPaciente :: new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarPaciente dadosAtualizarPaciente){
        var paciente = pacienteRepository.getReferenceById(dadosAtualizarPaciente.id());
        paciente.atualizarPaciente(dadosAtualizarPaciente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id ){
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
        //pacienteRepository.deleteById(id);
    }
}
