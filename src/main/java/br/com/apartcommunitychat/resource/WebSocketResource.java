package br.com.apartcommunitychat.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.RestController;

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

	private final SimpMessagingTemplate template;

	@Autowired
	WebSocketResource(SimpMessagingTemplate template) {
		this.template = template;
	}

	@MessageMapping(RECEIVING_URL)
	public void onReceiveMessage(String message) {
		this.template.convertAndSend(SENDING_URL, message);
		System.out.println("Mensagem Recebida: {" + message + "}");
	}

	@SubscribeMapping(SENDING_URL)
	public String onSubscribe() {
		return "Connect : " + message;
	}
}
