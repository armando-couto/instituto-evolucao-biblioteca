package br.com.empresa.biblioteca.apresentacao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.empresa.biblioteca.comum.entidade.Livro;
import br.com.empresa.biblioteca.negocio.LivroService;

@RequestScoped
@ManagedBean(name = "livroBean")
public class LivroBean {

	private Livro livro = new Livro();
	private LivroService livroService = new LivroService();

	public void incluir() {
		try {
			livroService.incluir(livro);
			livro = new Livro();
			MensagemUtil.exibirMsgSucesso("Livro cadastrado com sucesso.");
		} catch (RuntimeException e) {
			MensagemUtil.exibirMsgErro(e.getMessage());
		}
	}

	public String alterar() {
		try {
			livroService.alterar(livro);
			livro = new Livro();
			MensagemUtil.exibirMsgSucesso("Livro alterado com sucesso.");
			return "/cadastro/livro/listar.xhtml";
		} catch (RuntimeException e) {
			MensagemUtil.exibirMsgErro(e.getMessage());
			return null;
		}
	}
	
	public void excluir() {
		try {
			livroService.excluir(livro);
			livro = new Livro();
			MensagemUtil.exibirMsgSucesso("Livro excluido com sucesso.");
		} catch (RuntimeException e) {
			MensagemUtil.exibirMsgErro(e.getMessage());
		}
	}	

	public List<Livro> getLivros(){
		return livroService.consultarTodos();
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
