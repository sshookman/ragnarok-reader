package codepoet.ragnarok.reader;

import codepoet.ragnarok.reader.display.ConsoleDisplay;

public class Main {

	public static void main(String[] args) throws Exception {

        if (args.length() > 0) {
            System.exit(1);
        }

        String player = args[0];
        System.out.println(player);
		Reader reader = new Reader(new ConsoleDisplay(System.console()), "archives/Dragonfly.rgn");
		reader.read();
	}
}
