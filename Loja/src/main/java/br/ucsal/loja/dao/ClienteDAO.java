package br.ucsal.loja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.loja.builder.ClienteBuilder;
import br.ucsal.loja.model.Cliente;

public class ClienteDAO {

	private Connection connection;

	public ClienteDAO() {
		this.connection = ConnectionFactory.getConnection();
	}

	public void inserir(Cliente cliente) {
		String sql = "insert into cliente (nome, cpf, logradouro, numero, bairro, cidade, estado) values (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getLogradouro());
			stmt.setLong(4, cliente.getNumero());
			stmt.setString(5, cliente.getBairro());
			stmt.setString(6, cliente.getCidade());
			stmt.setString(7, cliente.getEstado());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Cliente getCliente(Long id) {
		ClienteBuilder clienteBuilder = ClienteBuilder.umCliente();
		Cliente cliente = clienteBuilder.build();
		try {
			String sql = "select * from cliente where id=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				cliente = clienteBuilder.mas().comNome(rs.getString("nome")).comId(rs.getLong("id"))
						.comCpf(rs.getString("cpf")).comLogradouro(rs.getString("logradouro"))
						.comBairro(rs.getString("bairro")).comNumero(rs.getLong("numero"))
						.comEstado(rs.getString("estado")).comCidade(rs.getString("cidade"))
						.build();						
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return cliente;
	}

	public List<Cliente> getLista() {
		try {
			List<Cliente> clientes = new ArrayList<>();
			String sql = "select * from cliente";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ClienteBuilder clienteBuilder = ClienteBuilder.umCliente();
				Cliente cliente = clienteBuilder.mas().comNome(rs.getString("nome")).comId(rs.getLong("id"))
						.comCpf(rs.getString("cpf")).comLogradouro(rs.getString("logradouro"))
						.comBairro(rs.getString("bairro")).comNumero(rs.getLong("numero"))
						.comEstado(rs.getString("estado")).comCidade(rs.getString("cidade"))
						.build();
				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Cliente cliente) {
		String sql = "update cliente set nome=?, cpf=?, logradouro=?, numero=?, bairro=?, cidade=?, estado=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getLogradouro());
			stmt.setLong(4, cliente.getNumero());
			stmt.setString(5, cliente.getBairro());
			stmt.setString(6, cliente.getCidade());
			stmt.setString(7, cliente.getEstado());
			stmt.setLong(8, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Long id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from cliente where id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
