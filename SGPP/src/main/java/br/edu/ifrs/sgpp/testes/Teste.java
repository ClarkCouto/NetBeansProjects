/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.sgpp.testes;

import br.edu.ifrs.sgpp.entities.Agenda;
import br.edu.ifrs.sgpp.entities.Aluno;
import br.edu.ifrs.sgpp.entities.Area;
import br.edu.ifrs.sgpp.entities.Bolsa;
import br.edu.ifrs.sgpp.entities.Cagppi;
import br.edu.ifrs.sgpp.entities.Colaborador;
import br.edu.ifrs.sgpp.entities.Coordenador;
import br.edu.ifrs.sgpp.entities.Curso;
import br.edu.ifrs.sgpp.entities.DataLimiteEntrega;
import br.edu.ifrs.sgpp.entities.Declaracao;
import br.edu.ifrs.sgpp.entities.Documento;
import br.edu.ifrs.sgpp.entities.Edital;
import br.edu.ifrs.sgpp.entities.GrupoDePesquisa;
import br.edu.ifrs.sgpp.entities.Instituicao;
import br.edu.ifrs.sgpp.entities.Pessoa;
import br.edu.ifrs.sgpp.entities.Projeto;
import br.edu.ifrs.sgpp.entities.SetorDePesquisa;
import br.edu.ifrs.sgpp.entities.TextoBaseDeclaracao;
import br.edu.ifrs.sgpp.entities.TipoDocumento;
import br.edu.ifrs.sgpp.dao.JPAUtil;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author 0729159
 */
public class Teste {
    public static void main(String[] args) {
        EntityManager em = null;
        EntityTransaction tx = null;
        
        System.out.println("Inicia Projeto!");
        try {
            System.out.println("Entrou try!");
            em = JPAUtil.getEntityManager();
            System.out.println("Criar transação!");
            tx = em.getTransaction();
            
            
            //================================
            //================================
            //====== Cria Instituicao ========
            //================================
            //================================
            Instituicao instituicao = new Instituicao();
            instituicao.setAtivo(Boolean.TRUE);
            instituicao.setNome("nome");
            //instituicao.setAlteradoPor();
            instituicao.setDataCadastro(new Date());
            instituicao.setDataUltimaAlteracao(new Date());
            
            //Pesiste a Instituicao
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir Instituicao!");
            em.persist(instituicao);
            System.out.println("Comitar Instituicao!");
            tx.commit();
            
            //Busca a Instituicao que foi cadastrada
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar Instituicao!");
            instituicao = em.find(Instituicao.class, 1);
            System.out.println("Comitar transação!");
            tx.commit();
            
            
            //================================
            //================================
            //===== Cria SetorDePesquisa =====
            //================================
            //================================
            SetorDePesquisa setorDePesquisa = new SetorDePesquisa();
            setorDePesquisa.setAtivo(Boolean.TRUE);
            setorDePesquisa.setNome("nome");
            setorDePesquisa.setEmail("email");
            setorDePesquisa.setTelefoneFixo("fixo");
            setorDePesquisa.setTelefoneCelular("celular");
            setorDePesquisa.setCpf(12345678910L);
            setorDePesquisa.setAtivo(Boolean.TRUE);
            setorDePesquisa.setSenha("senha");
            setorDePesquisa.setSexo(Pessoa.Sexo.Feminino);
            //setorDePesquisa.setAlteradoPor(setorDePesquisa);
            setorDePesquisa.setDataCadastro(new Date());
            setorDePesquisa.setDataUltimaAlteracao(new Date());
            
            //Pesiste a SetorDePesquisa
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir SetorDePesquisa!");
            em.persist(setorDePesquisa);
            System.out.println("Comitar SetorDePesquisa!");
            tx.commit();
            
            //Busca o SetorDePesquisa que foi cadastrado
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar SetorDePesquisa!");
            setorDePesquisa = em.find(SetorDePesquisa.class, 1L);
            System.out.println("Comitar transação!");
            tx.commit();
            
            
            //================================
            //================================
            //========= Cria Edital ==========
            //================================
            //================================
            System.out.println("Criar Edital!");
            Edital edital = new Edital();
            edital.setTitulo("titulo");
            edital.setNumero("numero");
            edital.setOrigem("origem");
            edital.setAtivo(Boolean.TRUE);
            edital.setAlteradoPor(setorDePesquisa);
            edital.setDataCadastro(new Date());
            edital.setDataUltimaAlteracao(new Date());
            
            //Pesiste o Edital
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir Edital!");
            em.persist(edital);
            System.out.println("Comitar Edital!");
            tx.commit();
            
            //Busca o Edital que foi cadastrado
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar Edital!");
            edital = em.find(Edital.class, 1L);
            System.out.println("Comitar transação!");
            tx.commit();
            
            
            //================================
            //================================
            //========== Cria Bolsa ==========
            //================================
            //================================
            System.out.println("Criar Bolsa!");
            Bolsa bolsa = new Bolsa();
            bolsa.setNome("nome");
            bolsa.setAtivo(Boolean.TRUE);
            bolsa.setEdital(edital);
            bolsa.setAlteradoPor(setorDePesquisa);
            bolsa.setDataCadastro(new Date());
            bolsa.setDataUltimaAlteracao(new Date());

            //Pesiste a Bolsa
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir 1 Bolsa!");
            em.persist(bolsa);
            System.out.println("Comitar transação!");
            tx.commit();
            
            System.out.println("Iniciar Loop Bolsa!");
            int i;
            
            for(i = 0; i < 5; i++){
                System.out.println("Iniciar transação!");
                tx.begin();
                System.out.println("Persistir Bolsa " + i + "!"); 
                bolsa = new Bolsa();
                bolsa.setNome("nome " + i);
                bolsa.setAtivo(Boolean.TRUE);
                bolsa.setEdital(edital);
                bolsa.setAlteradoPor(setorDePesquisa);
                bolsa.setDataCadastro(new Date());
                bolsa.setDataUltimaAlteracao(new Date());
                em.persist(bolsa);
                System.out.println("Comitar transação!");
                tx.commit();
            }
            
            //Busca a Bolsa que foi cadastrada
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar Bolsa!");
            bolsa = em.find(Bolsa.class, 1);
            System.out.println("Comitar transação!");
            tx.commit();
            
            
            //================================
            //================================
            //========= Cria Agenda ==========
            //================================
            //================================
            Agenda agenda = new Agenda();
            agenda.setAtivo(Boolean.TRUE);
            agenda.setEdital(edital);
            agenda.setAlteradoPor(setorDePesquisa);
            agenda.setDataCadastro(new Date());
            agenda.setDataUltimaAlteracao(new Date());
            
            //Pesiste a Agenda
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir Agenda!");
            em.persist(agenda);
            System.out.println("Comitar Agenda!");
            tx.commit();
            
            //Busca a Agenda que foi cadastrada
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar Agenda!");
            agenda = em.find(Agenda.class, 1L);
            System.out.println("Comitar transação!");
            tx.commit();
           
            
            //================================
            //================================
            //==== Cria DataLimiteEntrega ====
            //================================
            //================================
            DataLimiteEntrega dataLimite = new DataLimiteEntrega();
            dataLimite.setDescricao("descricao");
            dataLimite.setAgenda(agenda);
            dataLimite.setAtivo(Boolean.TRUE);
            dataLimite.setObrigatorio(Boolean.FALSE);
            dataLimite.setDataLimite(new Date());
            dataLimite.setAlteradoPor(setorDePesquisa);
            dataLimite.setDataCadastro(new Date());
            dataLimite.setDataUltimaAlteracao(new Date());
            
            //Pesiste a DataLimiteEntrega
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir DataLimiteEntrega!");
            em.persist(dataLimite);
            System.out.println("Comitar DataLimiteEntrega!");
            tx.commit();
            
            System.out.println("Iniciar Loop DataLimiteEntrega!");
            
            for(i = 0; i < 5; i++){
                System.out.println("Iniciar transação!");
                tx.begin();
                System.out.println("Persistir DataLimiteEntrega " + i + "!"); 
                dataLimite = new DataLimiteEntrega();
                dataLimite.setDescricao("descricao " + i);
                dataLimite.setAgenda(agenda);
                dataLimite.setAtivo(Boolean.TRUE);
                dataLimite.setObrigatorio(Boolean.FALSE);
                dataLimite.setDataLimite(new Date());
                dataLimite.setAlteradoPor(setorDePesquisa);
                dataLimite.setDataCadastro(new Date());
                dataLimite.setDataUltimaAlteracao(new Date());
                em.persist(dataLimite);
                System.out.println("Comitar transação!");
                tx.commit();
            }
            
            //Busca a DataLimiteEntrega que foi cadastrada
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar DataLimiteEntrega!");
            dataLimite = em.find(DataLimiteEntrega.class, 1L);
            System.out.println("Comitar transação!");
            tx.commit();
            
            
            //================================
            //================================
            //========== Cria Area ===========
            //================================
            //================================
            Area area = new Area();
            area.setAtivo(Boolean.TRUE);
            area.setNome("nome");
            area.setAlteradoPor(setorDePesquisa);
            area.setDataCadastro(new Date());
            area.setDataUltimaAlteracao(new Date());
            
            //Pesiste a Agenda
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir Area!");
            em.persist(area);
            System.out.println("Comitar Area!");
            tx.commit();
            
            //Busca a Agenda que foi cadastrada
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar Area!");
            area = em.find(Area.class, 1L);
            System.out.println("Comitar transação!");
            tx.commit();
            
            
            //================================
            //================================
            //========= Cria Cagppi ==========
            //================================
            //================================
            Cagppi cagppi = new Cagppi();
            cagppi.setAtivo(Boolean.TRUE);
            cagppi.setNome("nome");
            cagppi.setEmail("email");
            cagppi.setTelefoneFixo("fixo");
            cagppi.setTelefoneCelular("celular");
            cagppi.setCpf(12345678910L);
            cagppi.setAtivo(Boolean.TRUE);
            cagppi.setSenha("senha");
            cagppi.setSexo(Pessoa.Sexo.Masculino);
            cagppi.setAlteradoPor(setorDePesquisa);
            cagppi.setDataCadastro(new Date());
            cagppi.setDataUltimaAlteracao(new Date());
            
            //Pesiste a Cagppi
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir Cagppi!");
            em.persist(cagppi);
            System.out.println("Comitar Cagppi!");
            tx.commit();
            
            //Busca o Cagppi que foi cadastrado
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar Cagppi!");
            cagppi = em.find(Cagppi.class, 1L);
            System.out.println("Comitar transação!");
            tx.commit();
            
            
            //================================
            //================================
            //======= Cria Coordenador =======
            //================================
            //================================
            Coordenador coordenador = new Coordenador();
            coordenador.setAtivo(Boolean.TRUE);
            coordenador.setNome("nome");
            coordenador.setEmail("email");
            coordenador.setTelefoneFixo("fixo");
            coordenador.setTelefoneCelular("celular");
            coordenador.setCpf(12345678910L);
            coordenador.setAtivo(Boolean.TRUE);
            coordenador.setSenha("senha");
            coordenador.setSexo(Pessoa.Sexo.Masculino);
            coordenador.setSiape("siape");
            coordenador.setArea(area);
            coordenador.setAlteradoPor(setorDePesquisa);
            coordenador.setDataCadastro(new Date());
            coordenador.setDataUltimaAlteracao(new Date());
            
            //Pesiste a Coordenador
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir Coordenador!");
            em.persist(coordenador);
            System.out.println("Comitar Coordenador!");
            tx.commit();
            
            //Busca o Projeto que foi cadastrado
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar Coordenador!");
            coordenador = em.find(Coordenador.class, 1L);
            System.out.println("Comitar transação!");
            tx.commit();
            
            
            //================================
            //================================
            //==== Cria Grupo de Pesquisa ====
            //================================
            //================================
            GrupoDePesquisa gruposDePesquisa = new GrupoDePesquisa();
            gruposDePesquisa.setAtivo(Boolean.TRUE);
            gruposDePesquisa.setNome("nome");
            gruposDePesquisa.setCoordenador(coordenador);
            gruposDePesquisa.setAlteradoPor(setorDePesquisa);
            gruposDePesquisa.setDataCadastro(new Date());
            gruposDePesquisa.setDataUltimaAlteracao(new Date());
            
            //Pesiste o GrupoDePesquisa
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir GrupoDePesquisa!");
            em.persist(gruposDePesquisa);
            System.out.println("Comitar GrupoDePesquisa!");
            tx.commit();
            
            //Busca o GrupoDePesquisa que foi cadastrado
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar GrupoDePesquisa!");
            gruposDePesquisa = em.find(GrupoDePesquisa.class, 1L);
            System.out.println("Comitar transação!");
            tx.commit();
            
            
            //================================
            //================================
            //========= Cria Projeto =========
            //================================
            //================================
            Projeto projeto = new Projeto();
            projeto.setAipct(Boolean.TRUE);
            projeto.setAlteradoPor(setorDePesquisa);
            projeto.setAno(2017);
            projeto.setAtivo(Boolean.TRUE);
            projeto.setCoordenador(coordenador);
            projeto.setDataCadastro(new Date());
            projeto.setDataInicio(new Date());
            projeto.setDataUltimaAlteracao(new Date());
            projeto.setEdital(edital);
            projeto.setTitulo("titulo");
            
            //Pesiste a Projeto
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir Projeto!");
            em.persist(projeto);
            System.out.println("Comitar Projeto!");
            tx.commit();
            
            //Busca o Projeto que foi cadastrado
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar Projeto!");
            projeto = em.find(Projeto.class, 1L);
            System.out.println("Comitar transação!");
            tx.commit();
            
            
            //================================
            //================================
            //======= Cria Colaborador =======
            //================================
            //================================
            Colaborador colaborador = new Colaborador();
            colaborador.setNome("nome");
            colaborador.setAtivo(Boolean.TRUE);
            colaborador.setProjeto(projeto);
            colaborador.setAlteradoPor(setorDePesquisa);
            colaborador.setDataCadastro(new Date());
            colaborador.setDataUltimaAlteracao(new Date());
            
            //Pesiste o Colaborador
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir Colaborador!");
            em.persist(colaborador);
            System.out.println("Comitar Colaborador!");
            tx.commit();
            
            //Busca o Colaborador que foi cadastrada
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar Colaborador!");
            colaborador = em.find(Colaborador.class, 1L);
            System.out.println("Comitar transação!");
            tx.commit();
            
            
            //================================
            //================================
            //========== Cria Curso ==========
            //================================
            //================================
            Curso curso = new Curso();
            curso.setNome("nome");
            curso.setAtivo(Boolean.TRUE);
            curso.setInstituicao(instituicao);
            curso.setAlteradoPor(setorDePesquisa);
            curso.setDataCadastro(new Date());
            curso.setDataUltimaAlteracao(new Date());
            
            //Pesiste o Curso
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir Curso!");
            em.persist(curso);
            System.out.println("Comitar Curso!");
            tx.commit();
            
            //Busca o Curso que foi cadastrada
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar Curso!");
            curso = em.find(Curso.class, 1);
            System.out.println("Comitar transação!");
            tx.commit();
            
            
            //================================
            //================================
            //========== Cria Aluno ==========
            //================================
            //================================
            Aluno aluno = new Aluno();
            aluno.setAtivo(Boolean.TRUE);
            aluno.setNome("nome");
            aluno.setEmail("email");
            aluno.setTelefoneFixo("fixo");
            aluno.setTelefoneCelular("celular");
            aluno.setCpf(12345678910L);
            aluno.setAtivo(Boolean.TRUE);
            aluno.setSexo(Pessoa.Sexo.Masculino);
            aluno.setBolsista(Boolean.TRUE);
            aluno.setBolsa(bolsa);
            aluno.setCurso(curso);
            aluno.setAlteradoPor(setorDePesquisa);
            aluno.setDataCadastro(new Date());
            aluno.setDataUltimaAlteracao(new Date());
            
            //Pesiste o Aluno
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir Aluno!");
            em.persist(aluno);
            System.out.println("Comitar Aluno!");
            tx.commit();
            
            //Busca o Aluno que foi cadastrado
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar Aluno!");
            aluno = em.find(Aluno.class, 1L);
            System.out.println("Comitar transação!");
            tx.commit();
            
            System.out.println("Iniciar Loop Aluno!");
            
            for(i = 0; i < 5; i++){
                System.out.println("Iniciar transação!");
                tx.begin();
                System.out.println("Persistir Aluno " + i + "!"); 
                aluno = new Aluno();
                aluno.setNome("nome " + i);
                aluno.setEmail("email " + i);
                aluno.setTelefoneFixo("fixo " + i);
                aluno.setTelefoneCelular("celular " + i);
                aluno.setCpf(Long.parseLong(i+""));
                aluno.setAtivo(Boolean.TRUE);
                aluno.setSexo(Pessoa.Sexo.Masculino);
                aluno.setBolsista(Boolean.TRUE);
                aluno.setBolsa(bolsa);
                aluno.setCurso(curso);
                aluno.setAlteradoPor(setorDePesquisa);
                aluno.setDataCadastro(new Date());
                aluno.setDataNascimento(new Date());
                aluno.setDataUltimaAlteracao(new Date());
                aluno.setAlteradoPor(setorDePesquisa);
                aluno.setDataCadastro(new Date());
                aluno.setDataUltimaAlteracao(new Date());
                em.persist(aluno);
                System.out.println("Comitar transação!");
                tx.commit();
            }
            
           
            //================================
            //================================
            //====== Cria TipoDocumento ======
            //================================
            //================================
            TipoDocumento tipoDocumento = new TipoDocumento();
            tipoDocumento.setAtivo(Boolean.TRUE);
            tipoDocumento.setNome("nome");
            tipoDocumento.setAlteradoPor(setorDePesquisa);
            tipoDocumento.setDataCadastro(new Date());
            tipoDocumento.setDataUltimaAlteracao(new Date());
            
            //Pesiste a TipoDocumento
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir TipoDocumento!");
            em.persist(agenda);
            System.out.println("Comitar TipoDocumento!");
            tx.commit();
            
            //Busca a TipoDocumento que foi cadastrado
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar TipoDocumento!");
            tipoDocumento = em.find(TipoDocumento.class, 1);
            System.out.println("Comitar transação!");
            tx.commit();
            
            
            //================================
            //================================
            //======== Cria Documento ========
            //================================
            //================================
            Documento documento = new Documento();
            documento.setEntregue(Boolean.TRUE);
            documento.setAnexo("anexo");
            documento.setAtivo(Boolean.TRUE);
            documento.setDataEntregue(new Date());
            documento.setDataLimiteEntrega(dataLimite);
            documento.setTipoDocumento(tipoDocumento);
            documento.setAlteradoPor(setorDePesquisa);
            documento.setDataCadastro(new Date());
            documento.setDataUltimaAlteracao(new Date());
            
            //Pesiste a Documento
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir Documento!");
            em.persist(documento);
            System.out.println("Comitar Documento!");
            tx.commit();
            
            System.out.println("Iniciar Loop Documento!");
            
            for(i = 0; i < 5; i++){
                System.out.println("Iniciar transação!");
                tx.begin();
                System.out.println("Persistir Documento " + i + "!"); 
                documento = new Documento();
                documento.setEntregue(Boolean.FALSE);
                documento.setAtivo(Boolean.TRUE);
                //documento.setAnexo("anexo");
                //documento.setDataEntregue(new Date());
                documento.setDataLimiteEntrega(dataLimite);
                documento.setTipoDocumento(tipoDocumento);
                documento.setAlteradoPor(setorDePesquisa);
                documento.setDataCadastro(new Date());
                documento.setDataUltimaAlteracao(new Date());
                em.persist(documento);
                System.out.println("Comitar transação!");
                tx.commit();
            }
            
            //Busca a Agenda que foi cadastrada
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar Agenda!");
            agenda = em.find(Agenda.class, 1L);
            System.out.println("Comitar transação!");
            tx.commit();
           
            //================================
            //================================
            //=== Cria TextoBaseDeclaracao ===
            //================================
            //================================
            TextoBaseDeclaracao textoBaseDeclaracao = new TextoBaseDeclaracao();
            textoBaseDeclaracao.setAtivo(Boolean.TRUE);
            textoBaseDeclaracao.setIdentificador("identificador");
            textoBaseDeclaracao.setTexto("texto");
            textoBaseDeclaracao.setDataCadastro(new Date());
            textoBaseDeclaracao.setAlteradoPor(setorDePesquisa);
            textoBaseDeclaracao.setDataCadastro(new Date());
            textoBaseDeclaracao.setDataUltimaAlteracao(new Date());
            
            //Pesiste a TextoBaseDeclaracao
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir TextoBaseDeclaracao!");
            em.persist(textoBaseDeclaracao);
            System.out.println("Comitar TextoBaseDeclaracao!");
            tx.commit();
            
            //Busca o TextoBaseDeclaracao que foi cadastrado
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Encontrar TextoBaseDeclaracao!");
            textoBaseDeclaracao = em.find(TextoBaseDeclaracao.class, 1);
            System.out.println("Comitar transação!");
            tx.commit();
            
            
            //================================
            //================================
            //======== Cria Declaracao =======
            //================================
            //================================
            Declaracao declaracao = new Declaracao();
            declaracao.setAtivo(Boolean.TRUE);
            declaracao.setDataEmissao(new Date());
            declaracao.setProjeto(projeto);
            declaracao.setTextoBaseDeclaracao(textoBaseDeclaracao);
            declaracao.setResponsavel(coordenador);
            declaracao.setDestinatario(aluno);
            declaracao.setAlteradoPor(setorDePesquisa);
            declaracao.setDataCadastro(new Date());
            declaracao.setDataUltimaAlteracao(new Date());
            
            //Pesiste a Declaracao
            System.out.println("Iniciar transação!");
            tx.begin();
            System.out.println("Persistir Declaracao!");
            em.persist(declaracao);
            System.out.println("Comitar Declaracao!");
            tx.commit();
            
            System.out.println("Iniciar Loop Declaracao!");
            
            for(i = 0; i < 5; i++){
                System.out.println("Iniciar transação!");
                tx.begin();
                System.out.println("Persistir Declaracao " + i + "!"); 
                declaracao = new Declaracao();
                declaracao.setAtivo(Boolean.TRUE);
                declaracao.setDataEmissao(new Date());
                declaracao.setProjeto(projeto);
                declaracao.setTextoBaseDeclaracao(textoBaseDeclaracao);
                declaracao.setResponsavel(coordenador);
                declaracao.setAlteradoPor(setorDePesquisa);
                declaracao.setDataCadastro(new Date());
                declaracao.setDataUltimaAlteracao(new Date());
                em.persist(declaracao);
                System.out.println("Comitar transação!");
                tx.commit();
            }
//            
            System.out.println("Finalizou todas transações!");
        } catch (RuntimeException e) {
            
            System.out.println("Exceção Projeto!");
                e.printStackTrace();
            if (tx != null && tx.isActive()) {
                e.printStackTrace();
                System.out.println("Voltou na ação!");
                tx.rollback();
            }
        }
    }
}
