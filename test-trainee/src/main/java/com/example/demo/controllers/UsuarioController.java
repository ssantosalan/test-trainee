package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.dtos.UsuarioDTO;
import com.example.demo.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/save")
	public ResponseEntity<Object> post(@Valid @RequestBody UsuarioDTO usuarioDTO) {
		
		if (usuarioService.existeEmail(usuarioDTO)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email já cadastrado!");
		}
		
		usuarioService.create(usuarioDTO);

		return ResponseEntity.status(HttpStatus.OK).body("Usuário criado com sucesso!");
	}

}
