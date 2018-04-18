package codepoet.ragnarok.reader;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.File;
import codepoet.ragnarok.reader.display.ConsoleDisplay;

public class Main {

    private static final String archiveFolder = "archive/";
    private static final String playersFolder = "players/";
    private static final String extension = ".rgn";

	public static void main(String[] args) throws Exception {

        if (args.length < 2) {
            System.out.println("Insufficient Arguments");
            System.exit(1);
        }

        String player = args[0];
        String game   = args[1];
        System.out.println(player);
        System.out.println(game);

        String archive      = new StringBuilder().append(archiveFolder).append(game).append(extension).toString();
        String playerFolder = new StringBuilder().append(playersFolder).append(player).append("/").toString();
        String gameFile     = new StringBuilder().append(playerFolder).append(game).append(extension).toString();
        
        if (!Files.exists(Paths.get(archive))) {
            System.out.println("Unable to locate that archive");
            System.exit(1);
        }

        if (!Files.exists(Paths.get(playerFolder))) {
            File dir = new File(playerFolder);
            if (!dir.mkdir()) {
                System.out.println("Unable to create player folder");
                System.exit(1);
            }
        }

        if (!Files.exists(Paths.get(gameFile))) {
            Files.copy(Paths.get(archive), Paths.get(gameFile), StandardCopyOption.REPLACE_EXISTING);
        }

		Reader reader = new Reader(new ConsoleDisplay(System.console()), gameFile);
		reader.read();
	}
}
