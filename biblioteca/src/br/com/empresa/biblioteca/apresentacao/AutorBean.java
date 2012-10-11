package br.com.empresa.biblioteca.apresentacao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.empresa.biblioteca.comum.entidade.Autor;
import br.com.empresa.biblioteca.negocio.AutorService;

@RequestScoped
@ManagedBean(name = "autorBean")
public class AutorBean {

	private AutorService autorService = new AutorService();
	private Autor autor = new Autor();

	public void incluir() {
		try {
			autorService.incluir(autor);
			autor = new Autor();
			MensagemUtil.exibirMsgSucesso("Autor cadastrado com sucesso.");
		} catch (RuntimeException e) {
			MensagemUtil.exibirMsgErro(e.getMessage());
		}
	}
	
	public String alterar() {
		try {
			autorService.alterar(autor);
			autor = new Autor();
			MensagemUtil.exibirMsgSucesso("Autor alterado com sucesso.");
			return "/cadastro/autor/listar.xhtml";
		} catch (RuntimeException e) {
			MensagemUtil.exibirMsgErro(e.getMessage());
			return null;
		}
	}
	
	public void excluir() {
		try {
			autorService.excluir(autor);
			MensagemUtil.exibirMsgSucesso("Autor excluido com sucesso.");
		} catch (RuntimeException e) {
			MensagemUtil.exibirMsgErro(e.getMessage());
		}
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public List<Autor> getAutores() {
		return autorService.consultarTodos();
	}
}
