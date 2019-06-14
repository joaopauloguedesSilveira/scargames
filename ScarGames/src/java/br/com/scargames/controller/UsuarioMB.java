package br.com.scargames.controller;

import br.com.scargames.domain.Endereco;
import br.com.scargames.domain.Usuario;
import br.com.scargames.services.UsuarioService;
import br.com.scargames.util.UtilMessages;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "usuarioMB")
@SessionScoped
public class UsuarioMB implements Serializable{

    private Usuario usuario;
    private String email;
    private String senha;
    private List<Usuario> usuarios;
    
    /*public UsuarioMB() {
    }*/
    
    public UsuarioMB() {
        this.listar();
    }
    
    
    public void inicializarHibernate(){
        UsuarioService service = new UsuarioService();
        service.inicializarHibernate();
    }
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Endereço Editado", ((Endereco) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public String autenticar(){
        UsuarioService service = new UsuarioService();
        usuario = new Usuario(email, senha);
        if (service.autenticar(usuario)){
            return "/private/index.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Dados inválidos!");
            return null;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
     
    public void listar(){
        UsuarioService service = new UsuarioService();
        usuarios = service.listar();
    }
    
    public String novo(){
        usuario = new Usuario();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        UsuarioService service = new UsuarioService();
        if (service.inserir(usuario)){
            UtilMessages.messageInfo("Usuario cadastrada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar a usuario!");
            return null;
        }
    }
    
    public String alterar(){
        UsuarioService service = new UsuarioService();
        if (service.alterar(usuario)){
            UtilMessages.messageInfo("Usuario alterada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao alterar a usuario!");
            return null;
        }
    }
    
    public String carregarDados(Usuario usuario){
        this.usuario = usuario;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String excluir(Usuario usuario){
        UsuarioService service = new UsuarioService();
        if (service.excluir(usuario)){
            UtilMessages.messageInfo("Usuario excluída com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao excluir a usuario!");
            return null;
        }
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
}
