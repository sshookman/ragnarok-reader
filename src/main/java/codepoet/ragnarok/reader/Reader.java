package codepoet.ragnarok.reader;

import java.io.IOException;

import codepoet.ragnarok.reader.bo.RoomExpanded;
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
		Integer roomId = selection.equalsIgnoreCase("P") ? 1 : null;

		while (roomId != null) {
			RoomExpanded room = storyService.getRoom(roomId);
			display.write(room.getContent());
			display.prompt();
			roomId = null;
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
