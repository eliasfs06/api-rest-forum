package br.com.restapi.forum.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.restapi.forum.model.Topico;
import br.com.restapi.forum.repository.TopicoRepository;

public class AtualizarTopicoFormDTO {
	
	@NotNull @NotEmpty
	private String titulo;
	@NotNull @NotEmpty
	private String mensagem;

	public Topico atualizarTopico(Topico topico, TopicoRepository repository) {
			
		topico.setTitulo(titulo);
		topico.setMensagem(mensagem);
		
		repository.save(topico);
		return topico;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
