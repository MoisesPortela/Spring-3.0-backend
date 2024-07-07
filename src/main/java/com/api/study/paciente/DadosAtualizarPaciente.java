package com.api.study.paciente;

import com.api.study.endereco.DadosCadastroEndereco;

public record DadosAtualizarPaciente(Long id, String nome, String telefone, DadosCadastroEndereco endereco) {
}
