package br.com.restapi.forum.config.validacao;

public class FormError {

	private String menssagem;
	private String campo;
	
	public FormError(String menssagem, String campo) {
		super();
		this.menssagem = menssagem;
		this.campo = campo;
	}
	public String getMenssagem() {
		return menssagem;
	}
	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}
	public String getcampo() {
		return campo;
	}
	public void setcampo(String campo) {
		this.campo = campo;
	} 
	
}
