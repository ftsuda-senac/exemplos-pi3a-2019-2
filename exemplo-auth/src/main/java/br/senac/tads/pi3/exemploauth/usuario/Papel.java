/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemploauth.usuario;

import java.io.Serializable;

/**
 *
 * @author fernando.tsuda
 */
public class Papel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	public Papel() {
	}

	public Papel(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
