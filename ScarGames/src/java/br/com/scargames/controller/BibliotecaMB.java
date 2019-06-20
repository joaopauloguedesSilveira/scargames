/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.controller;

import br.com.scargames.domain.Biblioteca;
import br.com.scargames.domain.Jogo;
import br.com.scargames.domain.Usuario;
import br.com.scargames.services.BibliotecaService;
import br.com.scargames.services.JogoService;
import br.com.scargames.util.UtilMessages;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.scene.chart.PieChart.Data;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aluno1
 */
@ManagedBean(name = "bibliotecaMB")
@SessionScoped
public class BibliotecaMB implements Serializable {

    FacesContext context = FacesContext.getCurrentInstance();
    private UsuarioMB usuariomb = new UsuarioMB();
    
    HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    HttpSession sessao = rq.getSession();
    
    private int idUsuario;
    private int idJogo;
    
    private Usuario usuario = new Usuario();
    private Biblioteca biblioteca = new Biblioteca();
    private List<Biblioteca> bibliotecas = new ArrayList<>();
    
   
    
    public BibliotecaMB() {
        this.listar();
    }
    
    public void listar(){
        BibliotecaService service = new BibliotecaService();
        bibliotecas = service.listar();
    }
    
    public String novo(){
        biblioteca = new Biblioteca();
        return "new.xhtml?faces-redirect=true";
    }
    
    public void adicionarJogo(Jogo jogo){
        buscarIdJogo(jogo);
        BibliotecaService service = new BibliotecaService();
        
        usuario.setId(Integer.parseInt(String.valueOf(sessao.getAttribute("idUsuario"))));
        biblioteca.setUsuario(usuario);
        System.out.println("Id do usuario logado : " + usuario.getId());
        jogo.setId(idJogo);
        System.out.println("Id do jogo : " + jogo.getId());
        biblioteca.setJogo(jogo);
        if(service.inserir(biblioteca)){
            context.addMessage(null, new FacesMessage("Successful",  "Adicionado a Biblioteca !!! ") );
        }else{
            context.addMessage(null, new FacesMessage("Error",  "Erro ao adicionar !!! ") );
        }
    }
    
    public void buscarIdJogo(Jogo jogo){
        JogoService service = new JogoService();
        for(Jogo j : service.listar()){
            if(j.getTitulo().equals(jogo.getTitulo())){
                idJogo = j.getId();
            }
        }
    }
    
    public String inserir(){
        BibliotecaService service = new BibliotecaService();
        if (service.inserir(biblioteca)){
            UtilMessages.messageInfo("Biblioteca cadastrada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar biblioteca!");
            return null;
        }
    }
    
    public String alterar(){
        BibliotecaService service = new BibliotecaService();
        if (service.alterar(biblioteca)){
            UtilMessages.messageInfo("Biblioteca alterado com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao alterar biblioteca!");
            return null;
        }
    }
    
    public String carregarDados(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String excluir(Biblioteca biblioteca){
        BibliotecaService service = new BibliotecaService();
        if (service.excluir(biblioteca)){
            UtilMessages.messageInfo("Biblioteca excluída com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Erro ao excluir Biblioteca!");
            return null;
        }
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }

    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    
    
}
