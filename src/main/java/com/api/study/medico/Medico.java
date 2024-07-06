package com.api.study.medico;

import com.api.study.endereco.Endereco;

public record Medico(String nome, String email, String crm, Especialidade especialidade, Endereco endereco) {
}
