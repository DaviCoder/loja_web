package br.ucsal.loja.factories;

import br.ucsal.loja.dao.ClienteDAO;
import br.ucsal.loja.dao.IDAO;
import br.ucsal.loja.dao.ProdutoDAO;
import br.ucsal.loja.model.Cliente;
import br.ucsal.loja.model.Produto;

public class SingleFactory implements IDAOFactory {
    @Override
    public IDAO<Cliente> getClienteDAO() {
        return new ClienteDAO();
    }

    @Override
    public IDAO<Produto> getProdutoDAO() {
        return new ProdutoDAO();
    }
}
