package codepoet.ragnarok.reader;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArchiveManagerTest {

    @Test
    public static void testInitializeArchive() throws Exception {
        String gameFile = ArchiveManager.initializeArchive("test", "Ragnarok");
        assertEquals("players/test/Ragnarok.rgn", gameFile);
    }
}