package br.com.emersonmorgado.aluraflix.aluraflix.controller;

public enum Mensagem {

	VIDEO_NAO_ENCONTRADO("Vídeo não encontrado!"),
	CATEGORIA_NAO_ENCONTRADA("CategoriaId não encontrada!");

	private String descricao;
	
	Mensagem(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
			
}
