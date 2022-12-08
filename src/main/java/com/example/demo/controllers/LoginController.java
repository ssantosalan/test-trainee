package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Usuario;
import com.example.demo.entities.dtos.LoginDTO;
import com.example.demo.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping()
	public ResponseEntity<Object> login(@Valid @RequestBody LoginDTO loginDTO) {	
		
		Optional<Usuario> usuario = usuarioService.findByEmail(loginDTO);
		
		if (usuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário e/ou senha inválidos!");
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).body("Usuário logado com sucesso!");
	}
	
	
}
