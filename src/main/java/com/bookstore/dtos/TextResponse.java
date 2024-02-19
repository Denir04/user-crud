package com.bookstore.dtos;

public class TextResponse {
	private String messagem;

	public TextResponse(String messagem) {
		super();
		this.messagem = messagem;
	}

	public String getMessagem() {
		return messagem;
	}

	public void setMessagem(String messagem) {
		this.messagem = messagem;
	}
	
}
