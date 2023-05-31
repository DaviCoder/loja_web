package br.ucsal.loja.dao;
import java.util.List;
import java.sql.Connection;

public interface IDAO<T>{

    default Connection connection(Connection connection) {
        return connection;
    }

    void inserir(T t);

    T obter(Long id);

    List<T> listar();

    void alterar(T t);

    void remover(Long id);
}
