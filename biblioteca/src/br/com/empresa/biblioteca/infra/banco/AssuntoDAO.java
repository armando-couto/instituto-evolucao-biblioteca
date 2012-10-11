package br.com.empresa.biblioteca.infra.banco;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.empresa.biblioteca.comum.entidade.Assunto;

public class AssuntoDAO extends DAO {

	@SuppressWarnings("unchecked")
	public List<Assunto> consultarTodos() {
		return (List<Assunto>) consultarTodos(Assunto.class);
	}

	public Assunto consultarAssuntoPorNome(String nomeParaConsulta) {
		EntityManager gerente = fabrica.createEntityManager();
		try {
			Query consulta = gerente.createNamedQuery("consultarAssuntoPorNome");
			consulta.setParameter("nome", nomeParaConsulta);
			return (Assunto) consulta.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			gerente.close();
		}
	}
}
