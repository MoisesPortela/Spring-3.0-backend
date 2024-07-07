package com.api.study.medico;

import com.api.study.endereco.DadosCadastroEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosCadastroEndereco endereco
) {
}
