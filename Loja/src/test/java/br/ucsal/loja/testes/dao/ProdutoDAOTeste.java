package br.ucsal.loja.testes.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.ucsal.loja.dao.ProdutoDAO;
import br.ucsal.loja.model.Produto;
import br.ucsal.loja.testes.builder.ProdutoBuilder;

public class ProdutoDAOTeste {
	
	
	@Test
	public void obterProduto(Long id) {
		id = 3L;
		ProdutoBuilder produtoBuilder = ProdutoBuilder.umProduto();
		Produto produto = produtoBuilder.comName("Notebook").comStatus("A venda").comEmail("email@email.com")
				.comDescription("muito bom").comId(id).build();
		
		ProdutoDAO produtoDao = new ProdutoDAO();
		produtoDao.inserir(produto);
		
		Assertions.assertEquals(produtoDao.obter(id), 3L);
	}

}
