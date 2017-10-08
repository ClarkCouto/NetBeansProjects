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
public class Declaracao implements Serializable {
    private static final Long serialVersionUID = 5953225846505938118L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private Long idDeclaracao;
    
    @OneToOne
    private Pessoa alteradoPor;
    
    @Column(nullable=false)
    private Boolean ativo;
   
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissao;
    
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAlteracao;
    
    @ManyToOne
    private Pessoa destinatario;
    
    @ManyToOne
    private Projeto projeto;
    
    @ManyToOne
    private Coordenador responsavel;
    
    @ManyToOne
    private TextoBaseDeclaracao textoBaseDeclaracao;

    public Declaracao() {
    }

    public Declaracao(Long idDeclaracao, Pessoa alteradoPor, Boolean ativo, Date dataCadastro, Date dataEmissao, Date dataUltimaAlteracao, Pessoa destinatario, Projeto projeto, Coordenador responsavel, TextoBaseDeclaracao textoBaseDeclaracao) {
        this.idDeclaracao = idDeclaracao;
        this.alteradoPor = alteradoPor;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
        this.dataEmissao = dataEmissao;
        this.dataUltimaAlteracao = dataUltimaAlteracao;
        this.destinatario = destinatario;
        this.projeto = projeto;
        this.responsavel = responsavel;
        this.textoBaseDeclaracao = textoBaseDeclaracao;
    }

    public Long getIdDeclaracao() {
        return idDeclaracao;
    }

    public void setIdDeclaracao(Long idDeclaracao) {
        this.idDeclaracao = idDeclaracao;
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

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public Pessoa getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Pessoa destinatario) {
        this.destinatario = destinatario;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Coordenador getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Coordenador responsavel) {
        this.responsavel = responsavel;
    }

    public TextoBaseDeclaracao getTextoBaseDeclaracao() {
        return textoBaseDeclaracao;
    }

    public void setTextoBaseDeclaracao(TextoBaseDeclaracao textoBaseDeclaracao) {
        this.textoBaseDeclaracao = textoBaseDeclaracao;
    }

}
