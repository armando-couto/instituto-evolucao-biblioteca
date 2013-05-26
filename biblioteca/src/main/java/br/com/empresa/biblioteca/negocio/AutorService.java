package br.com.empresa.biblioteca.negocio;

import java.util.List;

import br.com.empresa.biblioteca.comum.entidade.Autor;
import br.com.empresa.biblioteca.infra.banco.AutorDAO;

public class AutorService {

	private AutorDAO autorDAO = new AutorDAO();

	public void incluir(Autor autor) {

		if (autor.getNome() == null || autor.getNome().trim().isEmpty()) {
			throw new RuntimeException("O atributo nome é obrigatório.");
		}

		int tamanho = autor.getNome().trim().length();
		if (tamanho < 3 || tamanho > 80) {
			throw new RuntimeException(
					"O atributo nome deve possuir entre 3 e 80 caracteres.");
		}

		autorDAO.incluir(autor);
	}

	public void alterar(Autor autor) {
		if (autor.getCodigo() == null || autor.getCodigo() <= 0) {
			throw new RuntimeException("Autor não cadastrado na base de dados.");
		}

		if (autor.getNome() == null || autor.getNome().trim().isEmpty()) {
			throw new RuntimeException("O atributo nome é obrigatório.");
		}

		int tamanho = autor.getNome().trim().length();
		if (tamanho < 3 || tamanho > 80) {
			throw new RuntimeException(
					"O atributo nome deve possuir entre 3 e 80 caracteres.");
		}

		autorDAO.alterar(autor);
	}

	public void excluir(Autor autor) {
		if (autor.getCodigo() == null || autor.getCodigo() <= 0) {
			throw new RuntimeException("Autor não cadastrado na base de dados.");
		}
		autorDAO.excluir(autor);
	}

	public List<Autor> consultarTodos() {
		return autorDAO.consultarTodos();
	}
}
