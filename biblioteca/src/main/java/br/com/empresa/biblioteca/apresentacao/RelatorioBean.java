package br.com.empresa.biblioteca.apresentacao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import formacaojava.jasper.Relatorio;

@RequestScoped
@ManagedBean(name = "relatorioBean")
public class RelatorioBean {

	public void listaAssuntos() {
		Relatorio.carregarRelatorio("/relatorios/ListaAssuntos.jasper", true);
	}
}
