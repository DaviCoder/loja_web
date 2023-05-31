package br.ucsal.loja.factories;

import br.ucsal.loja.dao.IDAO;
import br.ucsal.loja.model.Cliente;
import br.ucsal.loja.model.Produto;

public class DAOFactorySingleton {
    private static DAOFactorySingleton instance;
    private IDAO<Cliente> clienteDAO;
    private IDAO<Produto> produtoDAO;
    private SingleFactory singleFactory;

    private DAOFactorySingleton() {
        singleFactory = new SingleFactory();
    }

    public static synchronized DAOFactorySingleton getInstance() {
        if (instance == null) {
            instance = new DAOFactorySingleton();
        }
        return instance;
    }

    public IDAO<Cliente> getClienteDAO() {
        if (clienteDAO == null) {
            clienteDAO = singleFactory.getClienteDAO();
        }
        return clienteDAO;
    }

    public IDAO<Produto> getProdutoDAO() {
        if (produtoDAO == null) {
            produtoDAO = singleFactory.getProdutoDAO();
        }
        return produtoDAO;
    }
}