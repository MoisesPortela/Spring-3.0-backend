package com.api.study.controller;

import com.api.study.domain.paciente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPaciente dadosPaciente, UriComponentsBuilder uriComponentsBuilder){
        var paciente = new Paciente(dadosPaciente);
        pacienteRepository.save(paciente);
        var uri = uriComponentsBuilder.path("/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhadosPaciente(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var paciente = pacienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhadosPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> findAll(@PageableDefault(size = 10, sort = "nome") Pageable pageable){
        var page = pacienteRepository.findAllByAtivoTrue(pageable).map(DadosListagemPaciente :: new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarPaciente dadosAtualizarPaciente){
        var paciente = pacienteRepository.getReferenceById(dadosAtualizarPaciente.id());
        paciente.atualizarPaciente(dadosAtualizarPaciente);
        return ResponseEntity.ok().body(new DadosDetalhadosPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id ){
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
        //pacienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
