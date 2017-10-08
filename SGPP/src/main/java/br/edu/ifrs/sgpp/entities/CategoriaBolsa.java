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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author CristianoSilva
 */
@Entity
public class CategoriaBolsa implements Serializable {
    private static final long serialVersionUID = 5953225846505938118L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private Integer idCategoriaBolsa;
   
    private Pessoa alteradoPor;
    
    @Column(nullable=false)
    private Boolean ativo;
   
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
   
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAtualizacao;
    
    @Column(nullable=false, length=100)
    private String descricao;
    
    @Column(nullable=false)
    private Float valor;
    
    @OneToMany(mappedBy = "categoriaBolsa")
    private Collection<Bolsa> bolsas;

    public CategoriaBolsa() {
    }

    public CategoriaBolsa(Integer idCategoriaBolsa, Pessoa alteradoPor, Boolean ativo, Date dataCadastro, Date dataUltimaAtualizacao, String descricao, Float valor, Collection<Bolsa> bolsas) {
        this.idCategoriaBolsa = idCategoriaBolsa;
        this.alteradoPor = alteradoPor;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        this.descricao = descricao;
        this.valor = valor;
        this.bolsas = bolsas;
    }

    public Integer getIdCategoriaBolsa() {
        return idCategoriaBolsa;
    }

    public void setIdCategoriaBolsa(Integer idCategoriaBolsa) {
        this.idCategoriaBolsa = idCategoriaBolsa;
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

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Collection<Bolsa> getBolsas() {
        return bolsas;
    }

    public void setBolsas(Collection<Bolsa> bolsas) {
        this.bolsas = bolsas;
    }
    
}
