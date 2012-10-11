package br.com.empresa.biblioteca.infra.banco;

import java.util.List;

import br.com.empresa.biblioteca.comum.entidade.Autor;

public class AutorDAO extends DAO {

	@SuppressWarnings("unchecked")
	public List<Autor> consultarTodos() {
		return (List<Autor>) consultarTodos(Autor.class);
	}
}
