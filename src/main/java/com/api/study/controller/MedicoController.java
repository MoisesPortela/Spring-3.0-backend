package com.api.study.controller;

import com.api.study.medico.DadosCadastroMedico;
import com.api.study.medico.DadosListagemMedico;
import com.api.study.medico.Medico;
import com.api.study.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dadosMedico){
        medicoRepository.save(new Medico(dadosMedico));
    }

    @GetMapping
    public List<DadosListagemMedico> listar(){
        return medicoRepository.findAll().stream().map(DadosListagemMedico::new).toList();
    }
}
