package br.ucsal.loja.testes.builder;

import br.ucsal.loja.model.Cliente;

public class ClienteBuilder {
	
	private static final String DEFAULT_NOME = null;
	private static final String DEFAULT_CPF = null;
	private static final String DEFAULT_BAIRRO = null;
	private static final String DEFAULT_CIDADE = null;
	private static final String DEFAULT_ESTADO = null;
	private static final Long DEFAULT_NUMERO = null;
	private static final Long DEFAULT_ID= null;
	private static final String DEFAULT_LOGRADOURO = null;
	
	private String nome = DEFAULT_NOME;
	private String cpf = DEFAULT_CPF;
	private String bairro = DEFAULT_BAIRRO;
	private String estado= DEFAULT_ESTADO;
	private Long numero = DEFAULT_NUMERO;
	private Long id = DEFAULT_ID;
	private String cidade = DEFAULT_CIDADE;
	private String logradouro = DEFAULT_LOGRADOURO;
	
	
	
	private ClienteBuilder() {
		
	}
	
	public static ClienteBuilder umCliente() {
		return new ClienteBuilder();
	}
	
	public ClienteBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public ClienteBuilder comCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}
	
	public ClienteBuilder comBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}
	
	public ClienteBuilder comEstado(String estado) {
		this.estado = estado;
		return this;
	}
	
	public ClienteBuilder comCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}
	
	public ClienteBuilder comLogradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}
	
	public ClienteBuilder comNumero(Long numero) {
		this.numero = numero;
		return this;
	}
	
	public ClienteBuilder comId(Long id) {
		this.id = id;
		return this;
	}
	
	public ClienteBuilder mas() {
		return new ClienteBuilder().comNome(nome).comCpf(cpf).comId(id).comBairro(bairro).comEstado(estado)
				.comCidade(cidade).comLogradouro(logradouro).comNumero(numero);
	}
	
	public Cliente build() {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setEstado(estado);
		cliente.setBairro(bairro);
		cliente.setCidade(cidade);
		cliente.setId(id);
		cliente.setNumero(numero);
		cliente.setLogradouro(logradouro);
		return cliente;
	}

}
