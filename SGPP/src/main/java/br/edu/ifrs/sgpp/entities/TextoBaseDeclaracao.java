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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author CristianoSilva
 */
@Entity
public class TextoBaseDeclaracao implements Serializable{
    private static final Long serialVersionUID = 5953225846505938118L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private Integer idTextoBaseDeclaracao;
    
    @OneToOne
    private Pessoa alteradoPor;

    @Column(nullable=false)
    private Boolean ativo;
   
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    
    @Column(nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDesativacao;
    
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAlteracao;

    @Column(nullable=false, length=30)
    private String identificador;
    
    @Column(nullable=false)
    private String texto;

    public TextoBaseDeclaracao() {
    }

    public TextoBaseDeclaracao(Integer idTextoBaseDeclaracao, Pessoa alteradoPor, Boolean ativo, Date dataCadastro, Date dataDesativacao, Date dataUltimaAlteracao, String identificador, String texto) {
        this.idTextoBaseDeclaracao = idTextoBaseDeclaracao;
        this.alteradoPor = alteradoPor;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
        this.dataDesativacao = dataDesativacao;
        this.dataUltimaAlteracao = dataUltimaAlteracao;
        this.identificador = identificador;
        this.texto = texto;
    }

    public Integer getIdTextoBaseDeclaracao() {
        return idTextoBaseDeclaracao;
    }

    public void setIdTextoBaseDeclaracao(Integer idTextoBaseDeclaracao) {
        this.idTextoBaseDeclaracao = idTextoBaseDeclaracao;
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

    public Date getDataDesativacao() {
        return dataDesativacao;
    }

    public void setDataDesativacao(Date dataDesativacao) {
        this.dataDesativacao = dataDesativacao;
    }

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
