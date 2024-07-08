package com.api.study.domain.paciente;

import com.api.study.domain.endereco.DadosCadastroEndereco;

public record DadosAtualizarPaciente(Long id, String nome, String telefone, DadosCadastroEndereco endereco) {
}
