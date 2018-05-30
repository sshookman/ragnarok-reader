package codepoet.ragnarok.reader;

import codepoet.ragnarok.reader.dbo.Chapter;
import codepoet.ragnarok.reader.dbo.Path;
import codepoet.ragnarok.reader.dbo.Room;
import codepoet.ragnarok.reader.dbo.Title;
import codepoet.vaultmonkey.service.SqliteDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StoryServiceTest {

    @Mock
    private SqliteDataService<Title> titleDataService;

    @Mock
    private SqliteDataService<Chapter> chapterDataService;

    @Mock
    private SqliteDataService<Room> roomDataService;

    @Mock
    private SqliteDataService<Path> pathDataService;

    @InjectMocks
    private StoryService storyService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        Title title = new Title();
        title.setName("Test Story");
        title.setTag("scary,projectile,vomit");
        when(titleDataService.read(1)).thenReturn(title);

        Chapter chapter = new Chapter();
        chapter.setId(1);
        chapter.setName("Chapter 1");
        chapter.setContent("This is a test");
        when(chapterDataService.read(1)).thenReturn(chapter);

        Room room = new Room();
        room.setId(1);
        room.setChapterId(1);
        room.setName("A Dark Room");
        room.setContent("It's dark...");
        when(roomDataService.read(1)).thenReturn(room);

        List<Path> pathList = new ArrayList<>();
        Path path = new Path();
        path.setId(1);
        path.setChapterId(1);
        path.setRoomId(1);
        path.setDestRoomId(2);
        path.setName("the path");
        pathList.add(path);
        when(pathDataService.read(Mockito.any(Map.class)))
                .thenReturn(pathList)
                .thenReturn(new ArrayList())
                .thenReturn(null);
    }

    @Test
    public void getTitle() {
        Title title = storyService.getTitle();

        assertNotNull(title);
        assertEquals("Test Story", title.getName());
        assertEquals("scary,projectile,vomit", title.getTags());
    }

    @Test
    public void getChapter() {
        Chapter chapter = storyService.getChapter(1);

        assertNotNull(chapter);
        assertEquals(Integer.valueOf(1), chapter.getId());
        assertEquals("Chapter 1", chapter.getName());
        assertEquals("This is a test", chapter.getContent());
    }

    @Test
    public void getRoom() {
        Room room = storyService.getRoom(1);

        assertEquals(Integer.valueOf(1), room.getId());
        assertEquals(Integer.valueOf(1), room.getChapterId());
        assertEquals("A Dark Room", room.getName());
        assertEquals("It's dark...", room.getContent());
    }

    @Test
    public void getPath() {
        Path path = storyService.getPath(1, "the path");

        assertEquals(Integer.valueOf(1), path.getId());
        assertEquals(Integer.valueOf(1), path.getChapterId());
        assertEquals(Integer.valueOf(1), path.getRoomId());
        assertEquals(Integer.valueOf(2), path.getDestRoomId());
        assertEquals("the path", path.getName());

        assertNull(storyService.getPath(1, "no path"));
        assertNull(storyService.getPath(1, "no path"));
    }
}