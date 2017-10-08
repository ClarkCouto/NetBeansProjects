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
public class Edital implements Serializable{
    private static final Long serialVersionUID = 5953225846505938118L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private Long idEdital;
    
    @OneToOne
    private Agenda agenda;
    
    @OneToOne
    private Pessoa alteradoPor;

    @Column(nullable=false)
    private Boolean ativo;
    
    @OneToMany(mappedBy = "edital")
    private Collection<Bolsa> bolsas;
   
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAlteracao;
    
    @Column(nullable=false, length=50)
    private String numero;
    
    @Column(nullable=false, length=50)
    private String origem;
    
    @Column(nullable=true)
    private String pdf;
    
    @OneToMany(mappedBy = "edital")
    private Collection<Projeto> projetos;
    
    @Column(nullable=false, length=100)
    private String titulo;
    
    public Edital() {
    }

    public Edital(Long idEdital, Agenda agenda, Pessoa alteradoPor, Boolean ativo, Collection<Bolsa> bolsas, Date dataCadastro, Date dataUltimaAlteracao, String numero, String origem, String pdf, Collection<Projeto> projetos, String titulo) {
        this.idEdital = idEdital;
        this.agenda = agenda;
        this.alteradoPor = alteradoPor;
        this.ativo = ativo;
        this.bolsas = bolsas;
        this.dataCadastro = dataCadastro;
        this.dataUltimaAlteracao = dataUltimaAlteracao;
        this.numero = numero;
        this.origem = origem;
        this.pdf = pdf;
        this.projetos = projetos;
        this.titulo = titulo;
    }

    public Long getIdEdital() {
        return idEdital;
    }

    public void setIdEdital(Long idEdital) {
        this.idEdital = idEdital;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
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

    public Collection<Bolsa> getBolsas() {
        return bolsas;
    }

    public void setBolsas(Collection<Bolsa> bolsas) {
        this.bolsas = bolsas;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public Collection<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(Collection<Projeto> projetos) {
        this.projetos = projetos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
