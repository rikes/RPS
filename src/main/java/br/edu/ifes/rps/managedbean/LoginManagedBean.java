package br.edu.ifes.rps.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifes.rps.model.Usuario;
import br.edu.ifes.rps.repository.UsuarioDAO;

@ManagedBean(name="loginMB")
@ViewScoped
public class LoginManagedBean {

    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    
    @PostConstruct
    public void loginManagedBean(){
    	this.usuarioDAO = UsuarioDAO.getInstance();
    	this.usuario = new Usuario();
    }
   
    public String envia() {
          
    	
    	
          usuario = usuarioDAO.getUsuario(usuario.getNome(), usuario.getSenha());
          if (usuario == null) {
                usuario = new Usuario();
                FacesContext.getCurrentInstance().addMessage(
                           null,
                           new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                                       "Erro no Login!"));
                return null;
          } else {
                return "LOGIN DO MANAGED BEAN - MUDAR DPS";
          }
          
          
    }

    public Usuario getUsuario() {
          return usuario;
    }

    public void setUsuario(Usuario usuario) {
          this.usuario = usuario;
    }
}
