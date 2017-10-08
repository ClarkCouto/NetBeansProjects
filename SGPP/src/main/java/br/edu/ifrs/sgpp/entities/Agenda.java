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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author CristianoSilva
 */
@Entity
public class Agenda implements Serializable{
    private static final long serialVersionUID = 5953225846505938118L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private Long idAgenda;
    
    @OneToOne
    private Pessoa alteradoPor;
    
    @Column(nullable=false)
    private Boolean ativo;
    
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    
    @OneToMany(mappedBy = "agenda")
    private Collection<DataLimiteEntrega> datasLimiteEntrega;
    
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAlteracao;
    
    @OneToOne(mappedBy = "agenda")
    private Edital edital;
    

    public Agenda() {
    }

    public Agenda(Long idAgenda, Pessoa alteradoPor, Boolean ativo, Date dataCadastro, Collection<DataLimiteEntrega> datasLimiteEntrega, Date dataUltimaAlteracao, Edital edital) {
        this.idAgenda = idAgenda;
        this.alteradoPor = alteradoPor;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
        this.datasLimiteEntrega = datasLimiteEntrega;
        this.dataUltimaAlteracao = dataUltimaAlteracao;
        this.edital = edital;
    }

    public Long getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Long idAgenda) {
        this.idAgenda = idAgenda;
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

    public Collection<DataLimiteEntrega> getDatasLimiteEntrega() {
        return datasLimiteEntrega;
    }

    public void setDatasLimiteEntrega(Collection<DataLimiteEntrega> datasLimiteEntrega) {
        this.datasLimiteEntrega = datasLimiteEntrega;
    }

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public Edital getEdital() {
        return edital;
    }

    public void setEdital(Edital edital) {
        this.edital = edital;
    }

    
}
