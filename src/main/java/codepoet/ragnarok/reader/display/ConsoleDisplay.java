package codepoet.ragnarok.reader.display;

public class ConsoleDisplay implements DisplayInterface {

	private static final String RESET = "\u001B[0m";

	@Override
	public void write(String text) {
		System.out.println("\n" + text);
	}

	@Override
	public void write(RichText richText) {
		System.out.println(richText.getColor());
		writeByLetter(richText.getText(), richText.getSpeed());
		System.out.println(RESET);
	}

	@Override
	public void prompt() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void prompt(String text) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void prompt(RichText text) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
