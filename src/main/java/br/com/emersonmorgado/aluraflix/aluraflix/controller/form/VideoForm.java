package br.com.emersonmorgado.aluraflix.aluraflix.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Video;

public class VideoForm {
	
	@NotNull
	@NotEmpty
	@Length(min = 3, max = 60)
	private String titulo;
	
	@NotNull
	@NotEmpty
	@Length(min = 10, max = 300)
	private String descricao;
	
	@NotNull
	@NotEmpty
	@Length(min = 10, max = 100)
	private String url;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Video getVideo() {
		return new Video(titulo, descricao, url);
	}
	
}
