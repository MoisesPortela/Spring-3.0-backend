package com.api.study.controller;

import com.api.study.domain.consulta.DadosAgendarConsulta;
import com.api.study.domain.consulta.DadosDetalhamentoConsulta;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendarConsulta(@RequestBody @Valid DadosAgendarConsulta dadosAgendarConsulta){
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null,null,null,null));
    }
}
