package br.com.empresa.biblioteca.apresentacao;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagemUtil {

	public static void exibirMsgSucesso(String msg) {
		FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg,
				msg);
		FacesContext.getCurrentInstance().addMessage(null, fMsg);
	}

	public static void exibirMsgAdvertencia(String msg) {
		FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg,
				msg);
		FacesContext.getCurrentInstance().addMessage(null, fMsg);
	}

	public static void exibirMsgErro(String msg) {
		FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg,
				msg);
		FacesContext.getCurrentInstance().addMessage(null, fMsg);
	}

	public static void exibirMsgFatal(String msg) {
		FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg,
				msg);
		FacesContext.getCurrentInstance().addMessage(null, fMsg);
	}
}
