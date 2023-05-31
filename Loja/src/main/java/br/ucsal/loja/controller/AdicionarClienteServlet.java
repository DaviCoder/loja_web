package br.ucsal.loja.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.loja.dao.ClienteDAO;
import br.ucsal.loja.dao.IDAO;
import br.ucsal.loja.factories.DAOFactorySingleton;
import br.ucsal.loja.factories.SingleFactory;
import br.ucsal.loja.model.Cliente;

/**

 * @author Jean Xavier e Gleicy Maria

  */


@WebServlet("/AdicionarClienteServlet")
public class AdicionarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOFactorySingleton daoFactorySingleton = DAOFactorySingleton.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String logradouro = request.getParameter("logradouro");
		Long numero = 	Long.parseLong(request.getParameter("numero"));
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");

		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setLogradouro(logradouro);
		cliente.setNumero(numero);
		cliente.setBairro(bairro);
		cliente.setCidade(cidade);
		cliente.setEstado(estado);

		IDAO dao = daoFactorySingleton.getClienteDAO();
		dao.inserir(cliente);

		response.sendRedirect("ListarClientesServlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdicionarClienteForm.jsp");
		dispatcher.forward(request, response);
	}

}
