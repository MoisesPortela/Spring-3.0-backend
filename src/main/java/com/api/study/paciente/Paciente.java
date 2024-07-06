package com.api.study.paciente;

import com.api.study.endereco.Endereco;

public record Paciente(String nome, String email, String telefone, String cpf, Endereco endereco) {
}
