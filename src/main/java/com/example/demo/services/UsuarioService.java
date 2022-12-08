package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Usuario;
import com.example.demo.entities.dtos.LoginDTO;
import com.example.demo.entities.dtos.UsuarioDTO;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public boolean create(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario(usuarioDTO);

		try {
			usuarioRepository.save(usuario);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}

		return true;
	}

	public Optional<Usuario> findByEmail(LoginDTO loginDTO) {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(loginDTO.getEmail());
		if (validaSenha(usuario, loginDTO.getSenha())) {
			return usuario;
		}
		return Optional.empty();
	}
	
	public boolean existeEmail(UsuarioDTO usuarioDTO) {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioDTO.getEmail());
		
		if (usuario.isEmpty()) {
			return false;
		}
		return true;
		
	}

	private boolean validaSenha(Optional<Usuario> usuario, String senha) {

		if (usuario.isEmpty()) {
			return false;
		}

		Usuario user = usuario.get();

		if (user.getSenha().equals(senha)) {
			return true;
		}

		return false;
	}
	

}
