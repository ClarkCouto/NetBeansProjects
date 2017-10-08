/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.sgpp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author CristianoSilva
 */
@Entity
@DiscriminatorValue(value="coordenador")
public class Coordenador extends Usuario implements Serializable{
    private static final Long serialVersionUID = 5953225846505938118L;
    
    @ManyToOne
    private Area area;
    
    @OneToMany(mappedBy = "coordenador")
    private Collection<GrupoDePesquisa> gruposDePesquisa;
    
    @OneToMany(mappedBy = "responsavel")
    private Collection<Declaracao> responsavelDeclaracoes;
    
    @Column(nullable=false, length=50)
    private String siape;

    public Coordenador() {
        super();
    }

    public Coordenador(Area area, Collection<GrupoDePesquisa> gruposDePesquisa, Collection<Declaracao> responsavelDeclaracoes, String siape, String senha, Date ultimoAcesso, Long idPessoa, Pessoa alteradoPor, Boolean ativo, Long cpf, Date dataCadastro, Date dataNascimento, Date dataUltimaAlteracao, Collection<Declaracao> declaracoes, String email, Instituicao instituicao, String nome, Sexo sexo, String telefoneFixo, String telefoneCelular) {
        super(senha, ultimoAcesso, idPessoa, alteradoPor, ativo, cpf, dataCadastro, dataNascimento, dataUltimaAlteracao, declaracoes, email, instituicao, nome, sexo, telefoneFixo, telefoneCelular);
        this.area = area;
        this.gruposDePesquisa = gruposDePesquisa;
        this.responsavelDeclaracoes = responsavelDeclaracoes;
        this.siape = siape;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Collection<GrupoDePesquisa> getGruposDePesquisa() {
        return gruposDePesquisa;
    }

    public void setGruposDePesquisa(Collection<GrupoDePesquisa> gruposDePesquisa) {
        this.gruposDePesquisa = gruposDePesquisa;
    }

    public Collection<Declaracao> getResponsavelDeclaracoes() {
        return responsavelDeclaracoes;
    }

    public void setResponsavelDeclaracoes(Collection<Declaracao> responsavelDeclaracoes) {
        this.responsavelDeclaracoes = responsavelDeclaracoes;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }
    
}
