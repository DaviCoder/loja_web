package br.ucsal.loja.testes.builder;

import br.ucsal.loja.model.Papel;

public class PapelBuilder {
	private static final String DEFAULT_NOME = null;
	private static final Long DEFAULT_ID = null;
	
	
	private String nome = DEFAULT_NOME;
	private Long id = DEFAULT_ID;
	
	
	private PapelBuilder() {
		
	}
	
	public static PapelBuilder umPapel() {
		return new PapelBuilder();
	}
	
	public PapelBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public PapelBuilder comId(Long id) {
		this.id = id;
		return this;
	}
	
	public PapelBuilder mas() {
		return new PapelBuilder().comNome(nome).comId(id);
	}
	
	
	public Papel build() {
		Papel papel = new Papel();
		papel.setNome(nome);
		papel.setId(id);
		return papel;
	}
}
