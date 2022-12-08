package com.example.demo.entities.dtos;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Component
public class UsuarioDTO {

	private Integer id;

	@NotBlank(message = "Preencha o Nome")
	private String nome;
	@NotBlank(message = "Preencha o Sobrenome")
	private String sobrenome;
	@NotBlank(message = "Preencha o Email")
	@Email
	private String email;
	@NotBlank(message = "Preencha o Senha")
	private String senha;
	@NotBlank(message = "Preencha o CPF")
	@CPF
	private String CPF;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.sobrenome = usuario.getSobrenome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.CPF = usuario.getCPF();
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
