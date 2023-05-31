package br.ucsal.loja.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.loja.model.Produto;

public class ProdutoDAO implements IDAO<Produto> {
	@Override
	public void inserir(Produto produto) {
		String sql = "insert into produto (name,  status,  email,  description) values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection(ConnectionFactory.getConnection()).prepareStatement(sql);
			stmt.setString(1, produto.getName());
			stmt.setString(2, produto.getStatus());
			stmt.setString(3, produto.getEmail());
			stmt.setString(4, produto.getDescription());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Produto> listar() {
		try {
			List<Produto> produtos = new ArrayList<>();
			String sql = "select * from produto";
			PreparedStatement stmt = connection(ConnectionFactory.getConnection()).prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setName(rs.getString("name"));
				produto.setStatus(rs.getString("status"));
				produto.setEmail(rs.getString("email"));
				produto.setDescription(rs.getString("description"));
				produtos.add(produto);
			}
			rs.close();
			stmt.close();
			return produtos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Produto obter(Long id) {
		Produto produto = null;
		String sql = "select (id,name, status, email, description) where id=?";
		try {
			PreparedStatement stmt = connection(ConnectionFactory.getConnection()).prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setName(rs.getString("name"));
				produto.setStatus(rs.getString("status"));
				produto.setEmail(rs.getString("email"));
				produto.setDescription(rs.getString("description"));
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return produto;

	}

	@Override
	public void alterar(Produto produto) {
		String sql = "update dia set name=? status=? email=? description=? where id=?";
		try {
			PreparedStatement stmt = connection(ConnectionFactory.getConnection()).prepareStatement(sql);
			stmt.setString(1, produto.getName());
			stmt.setString(2, produto.getStatus());
			stmt.setString(3, produto.getEmail());
			stmt.setString(4, produto.getDescription());
			stmt.setLong(5, produto.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remover(Long id) {
		try {
			PreparedStatement stmt = connection(ConnectionFactory.getConnection()).prepareStatement("delete from produto where id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
