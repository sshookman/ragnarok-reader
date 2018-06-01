package codepoet.ragnarok.reader;

import codepoet.ragnarok.reader.display.ConsoleDisplay;

public class Main {

	public static void main(String[] args) {

        try {
            if (args.length < 2) {
                throw new Exception("Insufficient Arguments");
            }

            String player  = args[0];
            String game    = args[1];
            String archive = ArchiveManager.initializeArchive(player, game);

            new Reader(new ConsoleDisplay(System.console()), archive).read();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.exit(1);
        }
	}
}
