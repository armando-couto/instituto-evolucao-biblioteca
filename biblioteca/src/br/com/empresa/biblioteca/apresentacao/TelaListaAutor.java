package br.com.empresa.biblioteca.apresentacao;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.empresa.biblioteca.comum.entidade.Autor;
import br.com.empresa.biblioteca.negocio.AutorService;

@SuppressWarnings("serial")
public class TelaListaAutor extends JDialog {

	private AutorService autorService = new AutorService();

	private JScrollPane panelTabela;
	private JTable tabelaCliente;

	public TelaListaAutor() {
		Autor novoAutor = new Autor();
		novoAutor.setNome("Vixi");

		autorService.incluir(novoAutor);

		List<Autor> autores = autorService.consultarTodos();

		String[] colunas = { "Código", "Nome" };
		Object[][] dados = new Object[autores.size()][2];

		int i = 0;
		for (Autor autor : autores) {
			dados[i][0] = autor.getCodigo();
			dados[i][1] = autor.getNome();

			i++;
		}

		DefaultTableModel model = new DefaultTableModel(dados, colunas);
		tabelaCliente = new JTable(model);

		panelTabela = new JScrollPane(tabelaCliente);

		add(panelTabela);

		setSize(400, 300);
		setLocationRelativeTo(null);
		setTitle("Lista de Autores");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TelaListaAutor();
	}
}
