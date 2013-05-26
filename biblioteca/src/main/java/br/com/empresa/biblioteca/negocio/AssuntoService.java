package br.com.empresa.biblioteca.negocio;

import java.util.List;

import br.com.empresa.biblioteca.comum.entidade.Assunto;
import br.com.empresa.biblioteca.infra.banco.AssuntoDAO;

public class AssuntoService {

	private AssuntoDAO assuntoDAO = new AssuntoDAO();

	public void incluir(Assunto assunto) {
		if (assunto.getNome() == null || assunto.getNome().trim().isEmpty()) {
			throw new RuntimeException("O atributo nome é obrigatório.");
		}

		int tamanho = assunto.getNome().trim().length();
		if (tamanho < 3 || tamanho > 80) {
			throw new RuntimeException(
					"O atributo nome deve possuir entre 3 e 80 caracteres.");
		}

		Assunto assuntoVindoDoBanco = assuntoDAO
				.consultarAssuntoPorNome(assunto.getNome());
		if (assuntoVindoDoBanco != null) {
			throw new RuntimeException("Assunto já cadastrado.");
		}

		assuntoDAO.incluir(assunto);
	}

	public void alterar(Assunto assunto) {

		if (assunto.getCodigo() == null || assunto.getCodigo() <= 0) {
			throw new RuntimeException(
					"Assunto não cadastrado na base de dados.");
		}

		if (assunto.getNome() == null || assunto.getNome().trim().isEmpty()) {
			throw new RuntimeException("O atributo nome é obrigatório.");
		}

		int tamanho = assunto.getNome().trim().length();
		if (tamanho < 3 || tamanho > 80) {
			throw new RuntimeException(
					"O atributo nome deve possuir entre 3 e 80 caracteres.");
		}

		Assunto assuntoVindoDoBanco = assuntoDAO
				.consultarAssuntoPorNome(assunto.getNome());
		if (assuntoVindoDoBanco != null
				&& !assuntoVindoDoBanco.getCodigo().equals(assunto.getCodigo())) {
			throw new RuntimeException("Assunto já cadastrado.");
		}

		assuntoDAO.alterar(assunto);
	}

	public void excluir(Assunto assunto) {
		if (assunto.getCodigo() == null || assunto.getCodigo() <= 0) {
			throw new RuntimeException(
					"Assunto não cadastrado na base de dados.");
		}
		assuntoDAO.excluir(assunto);
	}

	public List<Assunto> consultarTodos() {
		return assuntoDAO.consultarTodos();
	}
}
