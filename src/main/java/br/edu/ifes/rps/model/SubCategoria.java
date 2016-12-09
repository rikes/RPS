package br.edu.ifes.rps.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="TB_SubCategoria")
public class SubCategoria implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdSubCategoria")
	@GeneratedValue
	private int id;
	
	@Column(name="NomeSubCategoria")
	private String subCategoria;
	
	/*
	 * Aqui ficará a chave estrangeira, por isso preciso do Join
	 * Eager pq preciso carregar tbm os dados do pai(categoria) de uma vez 
	 */	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="IdCategoria", referencedColumnName="IdCategoria")
	private Categoria categoria;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSubCategoria() {
		return subCategoria;
	}


	public void setSubCategoria(String subCategoria) {
		this.subCategoria = subCategoria;
	}
}