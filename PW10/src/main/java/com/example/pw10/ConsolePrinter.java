package PW10.src.main.java.com.example.pw10;

import org.springframework.stereotype.Component;

@Component
public class ConsolePrinter implements IPrinter {

	private final MessageService messageService;

	public ConsolePrinter(MessageService messageService) {
		this.messageService = messageService;
	}

	@Override
	public void doPrint() {
		System.out.println(messageService.getMessage());
	}
}
