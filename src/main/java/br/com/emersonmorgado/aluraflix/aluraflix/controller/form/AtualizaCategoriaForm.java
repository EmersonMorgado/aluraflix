package br.com.emersonmorgado.aluraflix.aluraflix.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;

public class AtualizaCategoriaForm {
	@NotNull
	@NotEmpty
	@Length(min = 3, max = 60)
	private String titulo;
	
	@NotNull
	@NotEmpty
	@Length(min = 3, max = 20)
	private String cor;

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

	public Categoria atualizar(Categoria categoria) {
		categoria.setTitulo(titulo);
		categoria.setCor(cor);
		return categoria;
	}
	
	
}
