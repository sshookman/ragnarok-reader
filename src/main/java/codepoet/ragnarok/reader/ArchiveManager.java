package codepoet.ragnarok.reader;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ArchiveManager {

    private static final String archiveFolder = "archive/";
    private static final String playersFolder = "players/";
    private static final String extension = ".rgn";

    /**
     * Initializes a new archive for the player if one does not already exist
     *
     * @param player - The player name
     * @param game - The archive name
     * @throws Exception
     */
    public static String initializeArchive(final String player, final String game) throws Exception {
        String archive      = new StringBuilder().append(archiveFolder).append(game).append(extension).toString();
        String playerFolder = new StringBuilder().append(playersFolder).append(player).append("/").toString();
        String gameFile     = new StringBuilder().append(playerFolder).append(game).append(extension).toString();

        if (!Files.exists(Paths.get(archive))) {
            throw new Exception("Unable to locate the archive");
        }

        if (!Files.exists(Paths.get(playerFolder))) {
            File dir = new File(playerFolder);
            if (!dir.mkdir()) {
                throw new Exception("Unable to create player folder");
            }
        }

        if (!Files.exists(Paths.get(gameFile))) {
            Files.copy(Paths.get(archive), Paths.get(gameFile), StandardCopyOption.REPLACE_EXISTING);
        }

        return gameFile;
    }
}
