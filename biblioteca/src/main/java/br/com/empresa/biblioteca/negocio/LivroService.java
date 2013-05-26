package br.com.empresa.biblioteca.negocio;

import java.util.List;

import br.com.empresa.biblioteca.comum.entidade.Livro;
import br.com.empresa.biblioteca.infra.banco.LivroDAO;

public class LivroService {

	private LivroDAO livroDAO = new LivroDAO();

	public void incluir(Livro livro) {

		if (livro.getTitulo() == null || livro.getTitulo().trim().isEmpty()) {
			throw new RuntimeException("O atributo nome é obrigatório.");
		}

		int tamanho = livro.getTitulo().trim().length();
		if (tamanho < 3 || tamanho > 80) {
			throw new RuntimeException(
					"O atributo nome deve possuir entre 3 e 80 caracteres.");
		}

		livroDAO.incluir(livro);
	}

	public void alterar(Livro livro) {
		if (livro.getCodigo() == null || livro.getCodigo() <= 0) {
			throw new RuntimeException("Livro não cadastrado na base de dados.");
		}

		if (livro.getTitulo() == null || livro.getTitulo().trim().isEmpty()) {
			throw new RuntimeException("O atributo nome é obrigatório.");
		}

		int tamanho = livro.getTitulo().trim().length();
		if (tamanho < 3 || tamanho > 80) {
			throw new RuntimeException(
					"O atributo nome deve possuir entre 3 e 80 caracteres.");
		}

		livroDAO.alterar(livro);
	}

	public void excluir(Livro livro) {
		if (livro.getCodigo() == null || livro.getCodigo() <= 0) {
			throw new RuntimeException("Livro não cadastrado na base de dados.");
		}
		livroDAO.excluir(livro);
	}

	public List<Livro> consultarTodos() {
		return livroDAO.consultarTodos();
	}
}
