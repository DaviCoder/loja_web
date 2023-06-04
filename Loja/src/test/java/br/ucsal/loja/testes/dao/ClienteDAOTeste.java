package br.ucsal.loja.testes.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.ucsal.loja.dao.ClienteDAO;
import br.ucsal.loja.model.Cliente;
import br.ucsal.loja.testes.builder.ClienteBuilder;

public class ClienteDAOTeste {
	
	
	
	@Test
	public void inserirCliente() {
		ClienteDAO clienteDao = mock(ClienteDAO.class);
		Cliente cliente = ClienteBuilder.umCliente().comNome("cliente").comId(3L).comCidade("cidade")
				.comBairro("bairro").comCpf("12390123").comEstado("estado").comLogradouro("logradouro")
				.comNumero(213092103L).build();
		clienteDao.inserir(cliente);
		Mockito.when(clienteDao.getCliente(cliente.getId())).thenReturn(cliente);
		
		assertEquals(cliente.getId(), 3L);
	}
}
