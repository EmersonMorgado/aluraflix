package br.com.emersonmorgado.aluraflix.aluraflix.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Video implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVideo")
	private Long idVideo;
	
	private String titulo;
	
	private String descricao;
	
	private String url;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Categoria", referencedColumnName = "idCategoria")
	private Categoria categoria; 
	
	public Video() {
	}
	
	public Video(Long idVideo, String titulo, String descricao, String url, Categoria categoria) {
		this.idVideo = idVideo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.url = url;
		this.categoria = categoria;
	}
	
	public Video(String titulo, String descricao, String url, Categoria categoria) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.url = url;
		this.categoria= categoria;
	}

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getIdVideo() {
		return idVideo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVideo == null) ? 0 : idVideo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		if (idVideo == null) {
			if (other.idVideo != null)
				return false;
		} else if (!idVideo.equals(other.idVideo))
			return false;
		return true;
	}

}
