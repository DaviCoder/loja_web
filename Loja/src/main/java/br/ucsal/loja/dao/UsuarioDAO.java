package br.ucsal.loja.dao;

import br.ucsal.loja.builder.PapelBuilder;
import br.ucsal.loja.builder.UsuarioBuilder;
import br.ucsal.loja.model.Papel;
import br.ucsal.loja.model.Usuario;

public class UsuarioDAO {

	
	public Usuario login(String email, String senha) {
		//TODO Usuario Fake Mock
		UsuarioBuilder usuarioBuilder = UsuarioBuilder.umUsuario();
		PapelBuilder papelBuilder= PapelBuilder.umPapel();
		Usuario usuario = usuarioBuilder.build();
		//usuario.se
		if(email.startsWith("admin@")) {
			Papel papel = papelBuilder.build();
			usuario = usuarioBuilder.mas().comPapel(papel).build();
			
		}else if(email.startsWith("cli@")){
			Papel papel = papelBuilder.build();
			usuario = usuarioBuilder.mas().comPapel(papel).build();
		}else {
			return null;
		}
		return usuario;
	}

}
