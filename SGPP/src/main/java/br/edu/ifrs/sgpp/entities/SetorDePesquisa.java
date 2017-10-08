/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.sgpp.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author CristianoSilva
 */
@Entity
@DiscriminatorValue(value="setorDePesquisa")
public class SetorDePesquisa extends Usuario implements Serializable{
    private static final Long serialVersionUID = 5953225846505938118L;

    public SetorDePesquisa() {
    }    

    public SetorDePesquisa(String senha, Date ultimoAcesso, Long idPessoa, Pessoa alteradoPor, Boolean ativo, Long cpf, Date dataCadastro, Date dataNascimento, Date dataUltimaAlteracao, Collection<Declaracao> declaracoes, String email, Instituicao instituicao, String nome, Sexo sexo, String telefoneFixo, String telefoneCelular) {
        super(senha, ultimoAcesso, idPessoa, alteradoPor, ativo, cpf, dataCadastro, dataNascimento, dataUltimaAlteracao, declaracoes, email, instituicao, nome, sexo, telefoneFixo, telefoneCelular);
    }
    
}
