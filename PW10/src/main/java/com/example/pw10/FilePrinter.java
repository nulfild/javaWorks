package PW10.src.main.java.com.example.pw10;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Component;

@Component
public class FilePrinter implements IPrinter {

	private final MessageService messageService;

	public FilePrinter(MessageService messageService) {
		this.messageService = messageService;
	}

	@Override
	public void doPrint() {
		try (
			PrintWriter writer = new PrintWriter(
				"output.txt",
				StandardCharsets.UTF_8
			)
		) {
			writer.println(messageService.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
