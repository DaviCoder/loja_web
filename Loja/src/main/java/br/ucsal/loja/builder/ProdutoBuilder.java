package br.ucsal.loja.builder;

import br.ucsal.loja.model.Produto;

public class ProdutoBuilder {
	
	
	private static final Long DEFAULT_ID = null;
	private static final String DEFAULT_NAME = null;
	private static final String DEFAULT_STATUS = null;
	private static final String DEFAULT_EMAIL = null;
	private static final String DEFAULT_DESCRIPTION = null;
	
	
	private Long id = DEFAULT_ID;
	private String name = DEFAULT_NAME;
	private String status = DEFAULT_STATUS;
	private String email= DEFAULT_EMAIL;
	private String description = DEFAULT_DESCRIPTION;
	
	
	private ProdutoBuilder() {
		
	}
	
	public static ProdutoBuilder umProduto() {
		return new ProdutoBuilder();
	}
	
	public ProdutoBuilder comName(String name) {
		this.name = name;
		return this;
	}
	
	public ProdutoBuilder comStatus(String status) {
		this.status = status;
		return this;
	}
	
	public ProdutoBuilder comEmail(String email) {
		this.email = email;
		return this;
	}
	
	public ProdutoBuilder comDescription(String description) {
		this.description = description;
		return this;
	}
	
	public ProdutoBuilder comId(Long id) {
		this.id = id;
		return this;
	}
	
	public ProdutoBuilder mas() {
		return new ProdutoBuilder().comName(name).comEmail(email).comStatus(status).comDescription(description).comId(id);
	}
	
	
	public Produto build() {
		Produto produto = new Produto();
		produto.setName(name);
		produto.setEmail(email);
		produto.setStatus(status);
		produto.setDescription(description);
		produto.setId(id);
		return produto;
	}
	
	
}
