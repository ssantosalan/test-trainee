package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	public Optional <Usuario> findByEmail(String email);
}
