package com.colegio.ProyectoColegio.service;
import java.util.List;

import com.colegio.ProyectoColegio.entity.Usuario;

public interface UsuarioService {
	public List<Usuario> findAll();
	public Usuario findById(int id);
	public Usuario findByEmail(String email);
	public List<Usuario> findByEmailContaining(String email);
	public Usuario buscarPorEmail(String email);
	public boolean validarContraseña(String email, String password);
	public Usuario create(Usuario obj);
	public Usuario update(Usuario obj);
	public int delete(int id);
    //public int deactivate(int id);
	//public int activate(int id);
}
