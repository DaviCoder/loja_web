package br.ucsal.loja.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.loja.builder.ProdutoBuilder;
import br.ucsal.loja.dao.ProdutoDAO;
import br.ucsal.loja.model.Produto;

/**
 * Servlet implementation class AlterarProdutoServlet
 */

@WebServlet("/AlterarProdutoServlet")
public class AlterarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		String nome = request.getParameter("nome");
		String status = request.getParameter("status");
		String email = request.getParameter("email");
		String description = request.getParameter("description");
		
		
		ProdutoBuilder produtoBuilder = ProdutoBuilder.umProduto();
		Produto produto = produtoBuilder.mas().comName(nome).comEmail(email).comStatus(status)
				.comDescription(description).build();
		
		ProdutoDAO dao=new ProdutoDAO();
		dao.altera(produto);
		
	}

}
