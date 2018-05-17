package codepoet.ragnarok.reader;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArchiveManagerTest {

    @Test
    public void testInitializeArchive() throws Exception {
        String gameFile = ArchiveManager.initializeArchive("test", "Dragonfly");
        assertEquals("players/test/Dragonfly.rgn", gameFile);
    }

    @Test
    public void testInitializeArchiveNotFound() throws Exception {
        try {
            ArchiveManager.initializeArchive("test", "Dragonflies");
            fail("Exception Expected");
        } catch(Exception exception) {
            assertNotNull(exception);
            assertEquals("Unable to locate the archive", exception.getMessage());
        }
    }

    @Test
    public void testInitializeArchiveCantCreateFolder() throws Exception {
        try {
            ArchiveManager.initializeArchive("test/test/test/test", "Dragonfly");
            fail("Exception Expected");
        } catch(Exception exception) {
            assertNotNull(exception);
            assertEquals("Unable to create player folder", exception.getMessage());
        }
    }
}