package br.com.empresa.biblioteca.apresentacao;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.empresa.biblioteca.comum.entidade.Assunto;

@FacesConverter(forClass = Assunto.class)
public class AssuntoConverter implements Converter, Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 1L;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string != null && !string.trim().isEmpty()) {
			Long codigo = Long.parseLong(string);
			Assunto assunto = new Assunto();
			assunto.setCodigo(codigo);
			return assunto;
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
		if (objeto != null && objeto instanceof Assunto) {
			Assunto assunto = (Assunto) objeto;
			if (assunto.getCodigo() != null) {
				return assunto.getCodigo().toString();
			}
		}
		return null;
	}
}