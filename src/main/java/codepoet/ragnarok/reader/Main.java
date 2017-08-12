package codepoet.ragnarok.reader;

import codepoet.ragnarok.reader.display.ConsoleDisplay;

public class Main {

	public static void main(String[] args) throws InterruptedException, Exception {

		Reader reader = new Reader(new ConsoleDisplay(), "archives/TestGame.rag");
		reader.read();
	}
}
