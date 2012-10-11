package br.com.empresa.biblioteca.apresentacao;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.empresa.biblioteca.comum.entidade.Autor;

@FacesConverter(forClass = Autor.class)
public class AutorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {

		if (string != null && !string.trim().isEmpty()) {
			Long codigo = Long.parseLong(string);
			Autor autor = new Autor();
			autor.setCodigo(codigo);
			return autor;
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {

		if (objeto != null && objeto instanceof Autor) {
			Autor autor = (Autor) objeto;
			if (autor.getCodigo() != null) {
				return autor.getCodigo().toString();
			}
		}
		return null;
	}

}
