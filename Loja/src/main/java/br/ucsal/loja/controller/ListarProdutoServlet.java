package br.ucsal.loja.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ListarProdutoServlet
 */

@WebServlet("/admin/ListarProdutosServlet")
public class ListarProdutoServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private DAOFactorySingleton daoFactorySingleton = DAOFactorySingleton.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProdutoServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDAO dao =  daoFactorySingleton.getProdutoDAO();
		List<Produto> produtos  = dao.listar();
		request.setAttribute("produtos", produtos);
		RequestDispatcher requestDispatcher =   request.getRequestDispatcher("/WEB-INF/ListarProduto.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

