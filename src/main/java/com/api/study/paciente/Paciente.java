package com.api.study.paciente;

import com.api.study.endereco.DadosCadastroEndereco;

public record Paciente(String nome, String email, String telefone, String cpf, DadosCadastroEndereco endereco) {
}
