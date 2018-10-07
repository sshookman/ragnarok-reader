package codepoet.ragnarok.reader;

import java.io.IOException;

import codepoet.ragnarok.reader.command.Command;
import codepoet.ragnarok.reader.command.CommandParser;
import codepoet.ragnarok.reader.dbo.Path;
import codepoet.ragnarok.reader.dbo.Room;
import codepoet.ragnarok.reader.dbo.Title;
import codepoet.ragnarok.reader.display.DisplayColor;
import codepoet.ragnarok.reader.display.DisplayInterface;
import codepoet.ragnarok.reader.display.DisplaySpeed;
import codepoet.ragnarok.reader.display.RichText;

//TODO: Add test cases for this and split into separate classes as needed
public class Reader {

	private final StoryService storyService;
	private final DisplayInterface display;
    private final CommandParser commandParser;

	public Reader(final DisplayInterface display, final String archive) throws Exception {
        display.write("Loading Ragnarok Reader...");
		this.display = display;
		this.storyService = new StoryService(archive);
        this.commandParser = new CommandParser();
        display.write("--------------------------");
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
	
    //TODO: Alter game loop to read state each iteration and update based on command
	private void play() throws IOException {
		Integer roomId = 1;

		while (roomId != null) {
            // Read current game state and display
			Room room = storyService.getRoom(roomId);
			display.write(room.getContent());

            // Prompt for user input and get the command
			String input = display.prompt();
            Command command = commandParser.parse(input);
            display.write(command.toString());
            if (command == null) {
                display.write("I don't understand...");
            }

            // Update game state based on the command using the associated service
			Path path = storyService.getPath(roomId, input); 
			roomId = (path != null) ? path.getDestRoomId() : null;
		}
	}
	
	private void exit() {
		RichText thanks = new RichText("Thanks for playing...", DisplayColor.GREEN, DisplaySpeed.SLOW);
		display.write(thanks);
	}
}
