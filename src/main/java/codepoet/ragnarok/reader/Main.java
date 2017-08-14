package codepoet.ragnarok.reader;

import codepoet.ragnarok.reader.display.ConsoleDisplay;

public class Main {

	public static void main(String[] args) throws Exception {

		Reader reader = new Reader(new ConsoleDisplay(System.console()), "archives/TestGame.rag");
		reader.read();
	}
}
