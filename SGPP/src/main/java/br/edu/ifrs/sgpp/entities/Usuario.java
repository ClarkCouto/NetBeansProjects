/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.sgpp.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author CristianoSilva
 */
@Entity
@DiscriminatorValue(value="usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario extends Pessoa implements Serializable{
    private static final Long serialVersionUID = 5953225846505938118L;
    
    @Column(nullable=false, length=30)
    private String senha;
    
    @Column(nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoAcesso;

    public Usuario() {
        super();
    }

    public Usuario(String senha, Date ultimoAcesso, Long idPessoa, Pessoa alteradoPor, Boolean ativo, Long cpf, Date dataCadastro, Date dataNascimento, Date dataUltimaAlteracao, Collection<Declaracao> declaracoes, String email, Instituicao instituicao, String nome, Sexo sexo, String telefoneFixo, String telefoneCelular) {
        super(idPessoa, alteradoPor, ativo, cpf, dataCadastro, dataNascimento, dataUltimaAlteracao, declaracoes, email, instituicao, nome, sexo, telefoneFixo, telefoneCelular);
        this.senha = senha;
        this.ultimoAcesso = ultimoAcesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

}
