package br.com.emersonmorgado.aluraflix.aluraflix.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	private String titulo;
	private String cor;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "idVideo", cascade = CascadeType.ALL)
	private List<Video> videos;
	
	public Categoria() {
	}

	public Categoria(String titulo, String cor) {
		this.titulo = titulo;
		this.cor = cor;
	}
	
	public Categoria(Long idCategoria, String titulo, String cor, List<Video> videos) {
		this.idCategoria = idCategoria;
		this.titulo = titulo;
		this.cor = cor;
		this.videos = videos;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
