package br.com.restapi.forum.dto;


import java.time.LocalDateTime;
import java.util.List;

import br.com.restapi.forum.model.Resposta;
import br.com.restapi.forum.model.StatusTopico;
import br.com.restapi.forum.model.Topico;

public class TopicoDTO {
	
	Long id;
	private String titulo;
	private String mensagem;
	private String nomeCurso;
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	private StatusTopico status;
	private List<Resposta> respostas;

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

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public void setStatus(StatusTopico status) {
		this.status = status;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public void toDTO(Topico topico) {
		setId(topico.getId());
		setTitulo(topico.getTitulo());
		setMensagem(topico.getMensagem());
		setNomeCurso(topico.getCurso().getNome());
		setDataCriacao(topico.getDataCriacao());
		setNomeAutor(topico.getAutor().getNome());
		setStatus(topico.getStatus());
		setRespostas(topico.getRespostas());
	}
	
}
