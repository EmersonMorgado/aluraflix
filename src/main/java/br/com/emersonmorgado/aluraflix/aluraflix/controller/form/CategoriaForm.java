package br.com.emersonmorgado.aluraflix.aluraflix.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;

public class CategoriaForm {
	
	private final String msgTitulo = "Título não deve estar em branco";
	private final String msgCor = "Cor não deve estar em branco";

	@NotNull(message = msgTitulo)
	@NotEmpty(message = msgTitulo)
	@Length(min = 3, max = 60)
	private String titulo;
	
	@NotNull(message = msgCor)
	@NotEmpty(message = msgCor)
	@Length(min = 3, max = 20)
	private String cor;
	
	public CategoriaForm(String titulo, String cor) {
		this.titulo = titulo;
		this.cor = cor;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getCor() {
		return cor;
	}
	public Categoria getCategoria() {
		return new Categoria(titulo, cor);
	}
}
