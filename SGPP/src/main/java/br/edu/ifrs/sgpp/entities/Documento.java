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
public class Documento implements Serializable{
    private static final Long serialVersionUID = 5953225846505938118L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private Long idDocumento;
    
    @OneToOne
    private Pessoa alteradoPor;
    
    @Column(nullable=true)
    private String anexo;
    
    @Column(nullable=false)
    private Boolean ativo;
   
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    
    @Column(nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEntregue;
    
    @ManyToOne
    private DataLimiteEntrega dataLimiteEntrega;
    
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAlteracao;
    
    @Column(nullable=false)
    private Boolean entregue;
    
    @ManyToOne
    private Projeto projeto;
    
    @ManyToOne
    private TipoDocumento tipoDocumento;

    public Documento() {
    }

    public Documento(Long idDocumento, Pessoa alteradoPor, String anexo, Boolean ativo, Date dataCadastro, Date dataEntregue, DataLimiteEntrega dataLimiteEntrega, Date dataUltimaAlteracao, Boolean entregue, Projeto projeto, TipoDocumento tipoDocumento) {
        this.idDocumento = idDocumento;
        this.alteradoPor = alteradoPor;
        this.anexo = anexo;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
        this.dataEntregue = dataEntregue;
        this.dataLimiteEntrega = dataLimiteEntrega;
        this.dataUltimaAlteracao = dataUltimaAlteracao;
        this.entregue = entregue;
        this.projeto = projeto;
        this.tipoDocumento = tipoDocumento;
    }

    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Pessoa getAlteradoPor() {
        return alteradoPor;
    }

    public void setAlteradoPor(Pessoa alteradoPor) {
        this.alteradoPor = alteradoPor;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
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

    public Date getDataEntregue() {
        return dataEntregue;
    }

    public void setDataEntregue(Date dataEntregue) {
        this.dataEntregue = dataEntregue;
    }

    public DataLimiteEntrega getDataLimiteEntrega() {
        return dataLimiteEntrega;
    }

    public void setDataLimiteEntrega(DataLimiteEntrega dataLimiteEntrega) {
        this.dataLimiteEntrega = dataLimiteEntrega;
    }

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public Boolean getEntregue() {
        return entregue;
    }

    public void setEntregue(Boolean entregue) {
        this.entregue = entregue;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

}
