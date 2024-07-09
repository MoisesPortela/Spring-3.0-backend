package com.api.study.domain.consulta;

import com.api.study.domain.medico.Especialidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendarConsulta(
        Long idMedico,
        @NotNull
        Long idPaciente,
        @NotNull
        @Future
        @JsonFormat(pattern = "dd/mm/yyyy HH:mm")
        LocalDateTime data,

        Especialidade especialidade) {
}
