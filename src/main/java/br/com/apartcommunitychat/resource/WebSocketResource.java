package br.com.apartcommunitychat.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.apartcommunitychat.dto.MessageDTO;

/**
 * Classe responsável por liberar um 'endpoint' ou 'url' para acessar o
 * WebSocket.
 * 
 * @author Luiz Oliveira
 * @since 26/04/2019
 *
 */

@RestController
public class WebSocketResource {

	private static final String SENDING_URL = "/send/message";
	private static final String RECEIVING_URL = "/receive/message";

	private String message;
	private Map<String, Object> headers;
	private final SimpMessagingTemplate template;

	@Autowired
	WebSocketResource(SimpMessagingTemplate template) {
		this.template = template;
		this.headers = new HashMap<>();

		headers.put(MessageHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8);
	}

	@MessageMapping(RECEIVING_URL)
	public void onReceiveMessage(@RequestBody MessageDTO message) {
		this.template.convertAndSend(SENDING_URL, convertMessageToJson(message), headers);
		System.out.println("Mensagem Recebida: {" + message + "}");
	}

	@SubscribeMapping(SENDING_URL)
	public String onSubscribe() {
		return "Connect : " + message;
	}

	/**
	 * Método responsável por converter um objeto do tipo 'MessageDTO' em JSON.
	 * 
	 */

	private String convertMessageToJson(MessageDTO message) {
		try {
			return new ObjectMapper().writeValueAsString(message);
		} catch (JsonProcessingException e) {
			return "";
		}
	}
}
