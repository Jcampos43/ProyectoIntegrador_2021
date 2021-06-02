package com.veterinaria.service;

import java.util.List;

import com.veterinaria.entity.Interfaz;

import com.veterinaria.entity.TipoUsuario;
import com.veterinaria.entity.Usuario;

public interface UsuarioService {
	
	public abstract Usuario iniciarSesion(Usuario bean);
	
	public abstract List<Interfaz> traerInterfazDeUsuario(int cod_tip_usu);

	public abstract List<TipoUsuario> traerTipoDeUsuario(int cod_tip_usu);

	//public abstract Usuario registrarUsuario(Usuario usuario);
	public abstract void registrarUsuario(Usuario usuario);
	//public abstract List<TipoUsuario> traerTipoDeUsuario(int cod_Usu);
	
	public abstract void eliminaUsuario(int cod);
	public abstract List<Usuario> buscaUsuarioPorNombre(String filtro);

	public abstract List<Usuario> listaUsuarios();
	
	//public List<Usuario> buscaXDniAndIdUsuarioNot(String dni_usu, int cod_usu);
	//public List<Usuario> buscaXDni(String dni_usu);


}