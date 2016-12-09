package br.edu.ifes.rps.model;

import java.io.Serializable;
import java.util.Calendar;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "TB_Usuario")
public class Usuario implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdUsuario")
	@GeneratedValue
	private int id;
	
	@Column(name = "NomeUsuario")
	private String nome;
	
	@Column(name = "EmailUsuario")
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DataCadastro")
	private Calendar dataCadastro;
	
	@Column(name = "SenhaUSuario")
	private String senha;
	
	/*
	 * Dono do relacionamento com SubCategoria
	 */
	@ManyToOne
	@JoinColumn(name="IdCategoria1",referencedColumnName="IdCategoria", nullable= true)
	private Categoria categoria1;
	
	@ManyToOne
	@JoinColumn(name="IdCategoria2",referencedColumnName="IdCategoria", nullable= true)
	private Categoria categoria2;
	
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}