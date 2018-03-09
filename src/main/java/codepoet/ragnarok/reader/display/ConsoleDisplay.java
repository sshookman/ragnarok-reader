package codepoet.ragnarok.reader.display;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleDisplay implements DisplayInterface {

	private static final String RESET = "\u001B[0m";
	private BufferedReader reader;

	public ConsoleDisplay(Console console) {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void write(String text) {
		System.out.println(text);
	}

	@Override
	public void write(RichText richText) {
		System.out.println(richText.getColor());
		writeByLetter(richText.getText(), richText.getSpeed());
		System.out.println(RESET);
	}

	@Override
	public String prompt() throws IOException {
		return reader.readLine();
	}

	@Override
	public String prompt(String text) throws IOException {
		write(text);
		return reader.readLine();
	}

	@Override
	public String prompt(RichText richText) throws IOException {
		System.out.println(richText.getColor());
		writeByLetter(richText.getText(), richText.getSpeed());
		String input = reader.readLine();
		System.out.println(RESET);
		return input;
	}

	private void writeByLetter(final String message, final int speed) {
		for (int index = 0; index < message.length(); index++) {
			try {
				char character = message.charAt(index);
				System.out.print(character);
				Thread.sleep(speed);
			} catch (InterruptedException ex) {
			}
		}
	}
}
