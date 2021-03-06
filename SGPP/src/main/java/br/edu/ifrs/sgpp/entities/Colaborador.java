/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.sgpp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author CristianoSilva
 */
@Entity
public class Colaborador implements Serializable{
    private static final Long serialVersionUID = 5953225846505938118L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private Long idColaborador;
    
    @OneToOne
    private Pessoa alteradoPor;
    
    @Column(nullable=false)
    private Boolean ativo;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAlteracao;
    
    @Column(nullable=false, length=50)
    private String nome;
    
    @ManyToOne
    private Projeto projeto;

    public Colaborador() {
    }

    public Colaborador(Long idColaborador, Pessoa alteradoPor, Boolean ativo, Date dataCadastro, Date dataUltimaAlteracao, String nome, Projeto projeto) {
        this.idColaborador = idColaborador;
        this.alteradoPor = alteradoPor;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
        this.dataUltimaAlteracao = dataUltimaAlteracao;
        this.nome = nome;
        this.projeto = projeto;
    }

    public Long getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Long idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Pessoa getAlteradoPor() {
        return alteradoPor;
    }

    public void setAlteradoPor(Pessoa alteradoPor) {
        this.alteradoPor = alteradoPor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

}
