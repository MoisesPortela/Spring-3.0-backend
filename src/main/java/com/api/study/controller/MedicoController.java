package com.api.study.controller;

import com.api.study.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = "nome") Pageable pageable){
        return medicoRepository.findAllByAtivoTrue(pageable).map(DadosListagemMedico::new);
    }


    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarMedico dadosAtualizarMedico){
       var medico = medicoRepository.getReferenceById(dadosAtualizarMedico.id());
       medico.atualizarMedico(dadosAtualizarMedico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        //efetuando exclusão lógica
        var medico=medicoRepository.getReferenceById(id);
        medico.excluir();
        //medicoRepository.deleteById(id);
    }
}
