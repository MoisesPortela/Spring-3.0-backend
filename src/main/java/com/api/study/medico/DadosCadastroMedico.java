package com.api.study.medico;

import com.api.study.endereco.DadosCadastroEndereco;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosCadastroEndereco endereco) {
}
