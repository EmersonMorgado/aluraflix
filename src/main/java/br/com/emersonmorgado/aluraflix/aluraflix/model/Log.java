package br.com.emersonmorgado.aluraflix.aluraflix.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Log {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	private Date data;
	
	public Log(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = new Date();
	}
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public Date getData() {
		return data;
	}
}
