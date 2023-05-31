package br.ucsal.loja.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.loja.dao.IDAO;
import br.ucsal.loja.dao.ProdutoDAO;
import br.ucsal.loja.factories.DAOFactorySingleton;
import br.ucsal.loja.model.Produto;

/**
 * Servlet implementation class AlterarProdutoServlet
 */

@WebServlet("/AlterarProdutoServlet")
public class AlterarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOFactorySingleton daoFactorySingleton = DAOFactorySingleton.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produto produto = new Produto();
		produto.setName("name");
		produto.setEmail("email");
		produto.setDescription("description");
		produto.setStatus("status");
		IDAO dao= daoFactorySingleton.getProdutoDAO();
		dao.alterar(produto);
		
	}

}
