package br.com.restapi.forum.dto;



import br.com.restapi.forum.model.Curso;
import br.com.restapi.forum.model.Topico;
import br.com.restapi.forum.repository.CursoRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class TopicoFormDTO {
	
	@NotNull @NotEmpty
	private String titulo;
	@NotNull @NotEmpty
	private String mensagem;
	@NotNull @NotEmpty
	private String nomeCurso;

	public Topico toTopico(CursoRepository cursoRepository) {
		
		Topico topico = new Topico();
		Curso curso = cursoRepository.findByNome(nomeCurso);
		
		topico.setCurso(curso);
		topico.setTitulo(titulo);
		topico.setMensagem(mensagem);

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

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
}
