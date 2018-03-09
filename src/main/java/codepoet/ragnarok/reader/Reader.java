package codepoet.ragnarok.reader;

import java.io.IOException;

import codepoet.ragnarok.reader.command.CommandParser;
import codepoet.ragnarok.reader.dbo.Path;
import codepoet.ragnarok.reader.dbo.Room;
import codepoet.ragnarok.reader.dbo.Title;
import codepoet.ragnarok.reader.display.DisplayColor;
import codepoet.ragnarok.reader.display.DisplayInterface;
import codepoet.ragnarok.reader.display.DisplaySpeed;
import codepoet.ragnarok.reader.display.RichText;

public class Reader {

	private final StoryService storyService;
	private final DisplayInterface display;
    private final CommandParser commandParser;

	public Reader(final DisplayInterface display, final String archive) throws Exception {
		this.display = display;
		this.storyService = new StoryService(archive);
        this.commandParser = new CommandParser(display);
	}

	public void read() throws IOException {

		while (true) {
			String selection = title(storyService.getTitle());
			if (selection.equalsIgnoreCase("P")) {
				play();
			} else if (selection.equalsIgnoreCase("E")) {
				break;
			}
		}
		
		exit();
	}

	private String title(Title title) throws IOException {
		display.write(title.getName());
		display.write("[P]LAY");
		display.write("[E]XIT");
		return display.prompt();
	}
	
	private void play() throws IOException {
		Integer roomId = 1;

		while (roomId != null) {
			Room room = storyService.getRoom(roomId);
			display.write(room.getContent());
			String command = display.prompt();
            // TODO: Testing command parsing via OpenNLP
            display.write("Parsing command...");
            display.write(commandParser.parse(command)[0]);
            display.write("Parsed");
			Path path = storyService.getPath(roomId, command); 
			roomId = (path != null) ? path.getDestRoomId() : null;
		}
	}
	
	private void exit() {
		RichText thanks = new RichText("Thanks for playing...", DisplayColor.GREEN, DisplaySpeed.SLOW);
		display.write(thanks);
	}
}
