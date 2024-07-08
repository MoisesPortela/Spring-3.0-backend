package com.api.study.domain.medico;

import com.api.study.domain.endereco.DadosCadastroEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosCadastroEndereco endereco
) {
}
