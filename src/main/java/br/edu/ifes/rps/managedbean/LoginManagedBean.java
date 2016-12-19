package br.edu.ifes.rps.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FlowEvent;

import br.edu.ifes.rps.model.Usuario;
import br.edu.ifes.rps.repository.UsuarioDAO;
import br.edu.ifes.rps.util.JSFUtil;

import java.util.Calendar;

@ManagedBean(name="loginMB")
@ViewScoped
public class LoginManagedBean {

    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private boolean skip;
    
    @PostConstruct
    public void loginManagedBean(){
    	this.usuarioDAO = UsuarioDAO.getInstance();
    	this.usuario = new Usuario();
    }
   
    public String envia() {
          usuario = usuarioDAO.getUsuario(usuario.getEmail(), usuario.getSenha());
    	      	
          if (usuario == null) {
                usuario = new Usuario();
                JSFUtil.adicionarMensagemErro("Erro ao efetuar login");                           
                return null;
          } else {
        	  	JSFUtil.adicionarMensagemSucesso("Bem vindo "+this.usuario.getNome());
                return null;
          }
    }
    
    public String salvar(){
    	
    	
    	this.usuario.setDataCadastro(Calendar.getInstance());
    	
    	try{
    		this.usuarioDAO.persist(this.usuario);
    	}catch (Exception e) {
			JSFUtil.adicionarMensagemErro("Erro ao salvar usuario");
		}
    	
    	JSFUtil.adicionarMensagemSucesso("Welcome: "+ this.usuario.getNome());
    	
    	return null;
    }
    
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
    
    public String cadastro(){
    	return "cadastro";
    }
    
    public Usuario getUsuario() {
          return usuario;
    }

    public void setUsuario(Usuario usuario) {
          this.usuario = usuario;
    }
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
}
