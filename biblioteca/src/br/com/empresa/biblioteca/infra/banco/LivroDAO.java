package br.com.empresa.biblioteca.infra.banco;

import java.util.List;

import br.com.empresa.biblioteca.comum.entidade.Livro;

public class LivroDAO extends DAO {

	@SuppressWarnings("unchecked")
	public List<Livro> consultarTodos() {
		return (List<Livro>) consultarTodos(Livro.class);
	}
}
