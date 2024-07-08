package com.api.study.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public Endereco(DadosCadastroEndereco endereco) {
        this.logradouro=endereco.logradouro();
        this.bairro= endereco.bairro();
        this.cep=endereco.cep();
        this.cidade=endereco.cidade();
        this.uf= endereco.uf();
        this.numero=endereco.numero();
        this.complemento= endereco.complemento();
    }

    public void atualizarEndereco(DadosCadastroEndereco dadosAtualizarEndereco) {
        if(dadosAtualizarEndereco.logradouro()!=null){
            this.logradouro=dadosAtualizarEndereco.logradouro();
        }
        if(dadosAtualizarEndereco.bairro()!=null){
            this.bairro=dadosAtualizarEndereco.bairro();
        }
        if(dadosAtualizarEndereco.cep()!=null){
            this.cep=dadosAtualizarEndereco.cep();
        }
        if(dadosAtualizarEndereco.cidade()!=null){
            this.cidade=dadosAtualizarEndereco.cidade();
        }
        if(dadosAtualizarEndereco.uf()!=null){
            this.uf=dadosAtualizarEndereco.uf();
        }
        if(dadosAtualizarEndereco.numero()!=null){
            this.numero=dadosAtualizarEndereco.numero();
        }
        if(dadosAtualizarEndereco.complemento()!=null){
            this.complemento=dadosAtualizarEndereco.complemento();
        }
    }
}
