package br.com.empresa.biblioteca.apresentacao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.empresa.biblioteca.comum.entidade.Assunto;
import br.com.empresa.biblioteca.negocio.AssuntoService;

@RequestScoped
@ManagedBean(name = "assuntoBean")
public class AssuntoBean {

	private Assunto assunto = new Assunto();
	private AssuntoService assuntoService = new AssuntoService();

	public void incluir() {
		try {
			assuntoService.incluir(assunto);
			MensagemUtil.exibirMsgSucesso("Assunto cadastrado com sucesso.");
		} catch (Exception e) {
			MensagemUtil.exibirMsgErro(e.getMessage());
		}
	}

	public String alterar() {
		try {
			assuntoService.alterar(assunto);
			MensagemUtil.exibirMsgSucesso("Assunto alterado com sucesso.");
			return "/cadastro/assunto/listar.xhtml";
		} catch (Exception e) {
			MensagemUtil.exibirMsgErro(e.getMessage());
			return null;
		}
	}

	public void excluir() {
		try {
			assuntoService.excluir(assunto);
			MensagemUtil.exibirMsgSucesso("Assunto excluido com sucesso.");
		} catch (Exception e) {
			MensagemUtil.exibirMsgErro(e.getMessage());
		}
	}

	public List<Assunto> getAssuntos() {
		return assuntoService.consultarTodos();
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}
}
