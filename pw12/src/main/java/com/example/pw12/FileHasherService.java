package com.example.pw12;

import jakarta.annotation.PreDestroy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import org.springframework.stereotype.Service;

@Service
public class FileHasherService {

	private String inputFilePath;
	private String outputFilePath;

	private File inputFile;

	public FileHasherService() {}

	public void run(String... args)
		throws IllegalArgumentException {
		if (args.length != 2) {
			throw new IllegalArgumentException(
				"You must provide 2 file paths"
			);
		}

		inputFilePath = args[0];
		outputFilePath = args[1];
		inputFile = new File(inputFilePath);
	}

	public void hashFile() throws Exception {
		FileOutputStream outputStream = new FileOutputStream(
			outputFilePath
		);
		if (!inputFile.exists()) {
			outputStream.write("null".getBytes());
			outputStream.close();
			return;
		}

		FileInputStream inputStream = new FileInputStream(
			inputFilePath
		);
		byte[] data = new byte[inputStream.available()];
		inputStream.read(data);
		inputStream.close();

		data =
			MessageDigest.getInstance("SHA-256").digest(data);

		outputStream.write(data);
		outputStream.close();
	}

	@PreDestroy
	public void deleteFile() {
		if (inputFile.exists()) {
			inputFile.delete();
		}
	}
}
