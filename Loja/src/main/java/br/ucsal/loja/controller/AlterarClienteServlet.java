package br.ucsal.loja.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/AlterarClienteServlet")
public class AlterarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.getCliente(id);
		request.setAttribute("cliente", cliente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AlterarClienteForm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String logradouro = request.getParameter("logradouro");
		Long numero = 	Long.parseLong(request.getParameter("numero"));
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");

		ClienteBuilder clienteBuilder = ClienteBuilder.umCliente();
		Cliente cliente = clienteBuilder.mas().comId(id).comNome(nome).comCpf(cpf).comBairro(bairro)
				.comCidade(cidade).comEstado(estado).comLogradouro(logradouro).comNumero(numero)
				.build();
		
		ClienteDAO dao = new ClienteDAO();
		dao.altera(cliente);
		
		List<Cliente> lista = dao.getLista();
		request.setAttribute("clientes", lista);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarClientes.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
