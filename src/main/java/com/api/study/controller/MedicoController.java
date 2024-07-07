package com.api.study.controller;

import com.api.study.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dadosMedico, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dadosMedico);
        medicoRepository.save(medico);
        var uri= uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhadosMedico(medico));
    }

    @GetMapping("/{id}")
    @ReadOnlyProperty
    public ResponseEntity detalhar( @PathVariable Long id){
        var medico=medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhadosMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = "nome") Pageable pageable){
        var page = medicoRepository.findAllByAtivoTrue(pageable).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarMedico dadosAtualizarMedico){
       var medico = medicoRepository.getReferenceById(dadosAtualizarMedico.id());
       medico.atualizarMedico(dadosAtualizarMedico);
       return ResponseEntity.ok(new DadosDetalhadosMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        //efetuando exclusão lógica
        var medico=medicoRepository.getReferenceById(id);
        medico.excluir();
        //medicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
