package br.edu.ifes.rps.teste.passos;


import org.junit.Assert;

import br.edu.ifes.rps.model.Usuario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginTestePassos {

	private Usuario usuario;
	
	@Given("^O usuario (\\d+) foi criado com sucesso$")
	public void criar_Usuario(String usuario, String email, String senha){
		this.usuario.setEmail(email);
		this.usuario.setNome(usuario);
		this.usuario.setSenha(senha);
	}
	
	
	@When("^usuario de email \"([^\"]*)\" e senha \"([^\"]*)\"$") 
	public void usuario_tenta_fazer_login(String email, String senha){
		
		Assert.assertEquals("Email"+ this.usuario.getEmail() + " não confere",email);
		
		Assert.assertEquals("Senha"+ this.usuario.getSenha() + " não confere",senha);
	}
	
	
	@Then("^O resultado do login foi: \"(.*?)\"$ ")
	public void resultado_da_autenticao(String email, String senha, String resultado_login){
		
		String erro = null; //Caso houver algum erro irá exibir nulo
		try{
			Assert.assertEquals(this.usuario.getEmail(), email);
		}catch (AssertionError ae) {
			erro = ae.toString(); 
		}
		System.out.println(resultado_login+" - "+erro);
		
		try{
			Assert.assertEquals(this.usuario.getEmail(), email);
		}catch (AssertionError ae) {
			erro = ae.toString(); 
		}
		System.out.println(resultado_login+" - "+erro);
		
//		if(this.usuario.getEmail().equals(email) && this.usuario.getSenha().equals(senha)){
//			System.out.println("Login efetuado com sucesso");
//		}else{
//			System.out.println("Senha ou email inválidos");
//		}
	}
	
}
