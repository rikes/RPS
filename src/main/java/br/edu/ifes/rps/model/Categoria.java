package br.edu.ifes.rps.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_Categoria")
public class Categoria implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdCategoria")
	@GeneratedValue
	private int id;
	
	@Column(name="NomeCategoria")
	private String categoria;
	
	
	/*
	 *  O lado dominante é representado por mappedBy, ou seja, Subcategoria é a relação dominante
	 *  Relação dominante é aquela que possui a chave estrangeira
	 *  Não preciso usar o @JoinColumn, pois é a Subcategoria que ficará com achave estrangeira
	 *  OBS: retirei o onetoMAny com mappeid, pois não é recoemndavél relacionamento Bidirecinal
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
