package br.ucsal.loja.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.loja.builder.ProdutoBuilder;
import br.ucsal.loja.dao.ProdutoDAO;
import br.ucsal.loja.model.Produto;

@WebServlet("/AdicionarProdutoServlet")
public class AdicionarProdutoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String status = request.getParameter("status");
		String email = request.getParameter("email");
		String description = request.getParameter("description");

		
		ProdutoBuilder produtoBuilder = ProdutoBuilder.umProduto();
		Produto produto = produtoBuilder.mas().comName(nome).comEmail(email).comStatus(status)
				.comDescription(description).build();
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.inserir(produto);

		List<Produto> lista = dao.getLista();
		request.setAttribute("produtos", lista);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarProduto.jsp");
		requestDispatcher.forward(request, response);

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
