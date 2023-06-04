package br.ucsal.loja.dao;

import br.ucsal.loja.model.Papel;
import br.ucsal.loja.model.Usuario;

public class UsuarioDAO {

	
	public Usuario login(String email, String senha) {
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		//usuario.se
		if(email.startsWith("admin@")) {
			Papel papel = new Papel();
			papel.setId(1l);
			papel.setNome("ADMIN");
			usuario.setPapel(papel);
		}else if(email.startsWith("cli@")){
			Papel papel = new Papel();
			papel.setId(2l);
			papel.setNome("CLIENTE");
			usuario.setPapel(papel);
		}else {
			return null;
		}
		return usuario;
	}

}
