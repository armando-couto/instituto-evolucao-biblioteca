package br.com.empresa.biblioteca.infra.banco;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.empresa.biblioteca.comum.entidade.Entidade;

public class DAO {
	protected EntityManagerFactory fabrica;

	public DAO() {
		fabrica = Persistence.createEntityManagerFactory("conexao1");
	}

	public void incluir(Entidade entidade) {
		EntityManager gerente = fabrica.createEntityManager();
		EntityTransaction transacao = gerente.getTransaction();
		transacao.begin();
		gerente.persist(entidade);
		transacao.commit();
		gerente.close();
	}

	public void alterar(Entidade entidade) {
		EntityManager gerente = fabrica.createEntityManager();
		EntityTransaction transacao = gerente.getTransaction();
		transacao.begin();
		gerente.merge(entidade);
		transacao.commit();
		gerente.close();
	}

	public void excluir(Entidade entidade) {
		EntityManager gerente = fabrica.createEntityManager();
		EntityTransaction transacao = gerente.getTransaction();
		transacao.begin();
		gerente.remove(gerente.merge(entidade));
		transacao.commit();
		gerente.close();
	}

	@SuppressWarnings("unchecked")
	protected List<? extends Entidade> consultarTodos(
			Class<? extends Entidade> classe) {
		EntityManager gerente = fabrica.createEntityManager();
		try {
			Query consulta = gerente.createQuery("select a from "
					+ classe.getSimpleName() + " a");
			return consulta.getResultList();
		} finally {
			gerente.close();
		}
	}
}
