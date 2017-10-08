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
public class GrupoDePesquisa implements Serializable{
    private static final Long serialVersionUID = 5953225846505938118L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private Long idGrupoPesquisa;
    
    @OneToOne
    private Pessoa alteradoPor;

    @Column(nullable=false)
    private Boolean ativo;
    
    @ManyToOne
    private Coordenador coordenador;
   
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAlteracao;
    
    @Column(nullable=false, length=50)
    private String nome;

    public GrupoDePesquisa() {
    }

    public GrupoDePesquisa(Long idGrupoPesquisa, Pessoa alteradoPor, Boolean ativo, Coordenador coordenador, Date dataCadastro, Date dataUltimaAlteracao, String nome) {
        this.idGrupoPesquisa = idGrupoPesquisa;
        this.alteradoPor = alteradoPor;
        this.ativo = ativo;
        this.coordenador = coordenador;
        this.dataCadastro = dataCadastro;
        this.dataUltimaAlteracao = dataUltimaAlteracao;
        this.nome = nome;
    }

    public Long getIdGrupoPesquisa() {
        return idGrupoPesquisa;
    }

    public void setIdGrupoPesquisa(Long idGrupoPesquisa) {
        this.idGrupoPesquisa = idGrupoPesquisa;
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

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
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

}
