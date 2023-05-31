package br.ucsal.loja.factories;

import br.ucsal.loja.dao.IDAO;
import br.ucsal.loja.model.Cliente;
import br.ucsal.loja.model.Produto;

public interface IDAOFactory {
    IDAO<Cliente> getClienteDAO();
    IDAO<Produto> getProdutoDAO();
}
