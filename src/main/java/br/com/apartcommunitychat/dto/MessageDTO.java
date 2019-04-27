package br.com.apartcommunitychat.dto;

import java.util.Date;

/**
 * Classe DTO responsável por representar um objeto 'Mensagem'.
 * 
 * @author Luiz Foli
 * @since 19/04/2019
 *
 */

public class MessageDTO {

	private String message;
	private String author;
	private Date dtSend;

	public MessageDTO() {

	}

	public MessageDTO(String message, String author, Date dtSend) {
		super();
		this.message = message;
		this.author = author;
		this.dtSend = dtSend;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDtSend() {
		return dtSend;
	}

	public void setDtSend(Date dtSend) {
		this.dtSend = dtSend;
	}

}
