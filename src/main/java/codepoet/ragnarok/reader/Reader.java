package codepoet.ragnarok.reader;

import java.io.IOException;

import codepoet.ragnarok.reader.dbo.Chapter;
import codepoet.ragnarok.reader.dbo.Room;
import codepoet.ragnarok.reader.dbo.Title;
import codepoet.ragnarok.reader.display.DisplayColor;
import codepoet.ragnarok.reader.display.DisplayInterface;
import codepoet.ragnarok.reader.display.DisplaySpeed;
import codepoet.ragnarok.reader.display.RichText;

public class Reader {

	private final StoryService storyService;
	private final DisplayInterface display;

	public Reader(final DisplayInterface display, final String archive) throws Exception {
		this.display = display;
		this.storyService = new StoryService(archive);
	}

	public void read() throws IOException {

		String selection = title(storyService.getTitle());	
		Chapter chapter = storyService.getChapter(1);
		Room room = storyService.getRoom(chapter.getStartRoomId());

		while (room != null) {
			display.write(room.getContent());
			display.prompt();
			room = null;
		}

		RichText thanks = new RichText("Thanks for playing...", DisplayColor.GREEN, DisplaySpeed.SLOW);
		display.write(thanks);
	}

	private String title(Title title) throws IOException {
		display.write(title.getName());
		display.write("[P]LAY");
		display.write("[E]XIT");
		return display.prompt();
	}
}
