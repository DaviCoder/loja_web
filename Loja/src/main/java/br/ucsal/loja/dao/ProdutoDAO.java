package br.ucsal.loja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.loja.builder.ProdutoBuilder;
import br.ucsal.loja.model.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO() {
		this.connection = ConnectionFactory.getConnection();
	}

	public void inserir(Produto produto) {
		String sql = "insert into produto (name,  status,  email,  description) values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
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

	public List<Produto> getLista() {
		try {
			List<Produto> produtos = new ArrayList<>();
			String sql = "select * from produto";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ProdutoBuilder produtoBuilder = ProdutoBuilder.umProduto();
				Produto produto = produtoBuilder.mas().comName(rs.getString("nome"))
						.comEmail(rs.getString("email")).comStatus(rs.getString("status"))
						.comDescription(rs.getString("description")).build();
				produtos.add(produto);
			}
			rs.close();
			stmt.close();
			return produtos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Produto obter(Long id) {
		ProdutoBuilder produtoBuilder = ProdutoBuilder.umProduto();
		Produto produto = produtoBuilder.build();
		String sql = "select (id,name, status, email, description) where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				produto = produtoBuilder.mas().comName(rs.getString("nome"))
						.comEmail(rs.getString("email")).comStatus(rs.getString("status"))
						.comDescription(rs.getString("description")).build();
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return produto;

	}

	public void altera(Produto produto) {
		String sql = "update dia set name=? status=? email=? description=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
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

	public void remove(Produto produto) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from produto where id=?");
			stmt.setLong(1, produto.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
