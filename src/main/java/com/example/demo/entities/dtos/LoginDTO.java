package com.example.demo.entities.dtos;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Component
public class LoginDTO {
	
	@NotBlank(message = "Preencha o Email")
	@Email
	private String email;
	@NotBlank(message = "Preencha o Senha")
	private String senha;

	public LoginDTO() {
	}

	public LoginDTO(String email, String senha) {
		this.email = email;
		this.senha = senha;
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

}
