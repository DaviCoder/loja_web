package br.ucsal.loja.builder;

import br.ucsal.loja.model.Usuario;

public class UsuarioBuilder {
	
	
	private static final Long DEFAULT_ID = null;
	private static final String DEFAULT_EMAIL = null;
	private static final String DEFAULT_SENHA = null;
	
	
	private Long id = DEFAULT_ID;
	private String email = DEFAULT_EMAIL;
	private String senha = DEFAULT_SENHA;
	
	private UsuarioBuilder() {
		
	}
	
	public static UsuarioBuilder umUsuario() {
		return new UsuarioBuilder();
	}
	
	
	public UsuarioBuilder comEmail(String email) {
		this.email = email;
		return this;
	}
	
	
	public UsuarioBuilder comId(Long id) {
		this.id = id;
		return this;
	}
	
	public UsuarioBuilder comSenha(String senha) {
		this.senha = senha;
		return this;
	}
	
	public UsuarioBuilder mas() {
		return new UsuarioBuilder().comEmail(email).comSenha(senha).comId(id);
	}
	
	public Usuario build() {
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setId(id);
		return usuario;
		
	}
}
