package br.com.apartcommunitychat.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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

	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private Date dtSend;

	@JsonFormat(pattern = "HH:mm:ss", shape = JsonFormat.Shape.STRING)
	private String timeDtSend;

	public MessageDTO() {

	}

	public MessageDTO(String message, String author, Date dtSend, String timeDtSend) {
		super();
		this.message = message;
		this.author = author;
		this.dtSend = dtSend;
		this.timeDtSend = timeDtSend;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageDTO [message=");
		builder.append(message);
		builder.append(", author=");
		builder.append(author);
		builder.append(", dtSend=");
		builder.append(dtSend);
		builder.append(", timeDtSend=");
		builder.append(timeDtSend);
		builder.append("]");
		return builder.toString();
	}

}
