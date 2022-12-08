package com.example.demo.entities;

import com.example.demo.entities.dtos.UsuarioDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String CPF;

	public Usuario() {
	}

	public Usuario(UsuarioDTO usuarioDTO) {
		this.id = usuarioDTO.getId();
		this.nome = usuarioDTO.getNome();
		this.sobrenome = usuarioDTO.getSobrenome();
		this.email = usuarioDTO.getEmail();
		this.senha = usuarioDTO.getSenha();
		this.CPF = usuarioDTO.getCPF();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

}
