package br.ucsal.loja.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.loja.builder.ClienteBuilder;
import br.ucsal.loja.dao.ClienteDAO;
import br.ucsal.loja.model.Cliente;

/**

 * @author Jean Xavier e Gleicy Maria

  */


@WebServlet("/AdicionarClienteServlet")
public class AdicionarClienteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String logradouro = request.getParameter("logradouro");
		Long numero = 	Long.parseLong(request.getParameter("numero"));
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		
		ClienteBuilder clienteBuilder = ClienteBuilder.umCliente();
		
		Cliente cliente = clienteBuilder.mas().comNome(nome).comCpf(cpf).comBairro(bairro)
				.comCidade(cidade).comEstado(estado).comLogradouro(logradouro).comNumero(numero)
				.build();

//		Cliente cliente = new Cliente();
//		cliente.setNome(nome);
//		cliente.setCpf(cpf);
//		cliente.setLogradouro(logradouro);
//		cliente.setNumero(numero);
//		cliente.setBairro(bairro);
//		cliente.setCidade(cidade);
//		cliente.setEstado(estado);

		ClienteDAO dao = new ClienteDAO();
		dao.inserir(cliente);

		response.sendRedirect("ListarClientesServlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdicionarClienteForm.jsp");
		dispatcher.forward(request, response);
	}

}
