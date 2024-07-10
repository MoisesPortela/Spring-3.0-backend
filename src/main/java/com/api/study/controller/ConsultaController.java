package com.api.study.controller;

import com.api.study.domain.consulta.AgendaDeConsulta;
import com.api.study.domain.consulta.DadosAgendarConsulta;
import com.api.study.domain.consulta.DadosCancelarConsulta;
import com.api.study.domain.consulta.DadosDetalhamentoConsulta;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {
    @Autowired
    private AgendaDeConsulta agendaDeConsulta;

    @PostMapping
    @Transactional
    public ResponseEntity agendarConsulta(@RequestBody @Valid DadosAgendarConsulta dadosAgendarConsulta){
        var dadosConsulta=agendaDeConsulta.agendar(dadosAgendarConsulta);
        return ResponseEntity.ok(dadosConsulta) ;
    }
    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelarConsulta dadosCancelarConsulta){
        agendaDeConsulta.cancelar(dadosCancelarConsulta);
        return ResponseEntity.noContent().build();
    }
}
