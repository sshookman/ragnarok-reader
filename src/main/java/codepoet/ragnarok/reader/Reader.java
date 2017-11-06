package codepoet.ragnarok.reader;

import java.io.IOException;

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

		String selection = title(storyService.getTitle());		/*
		Integer areaId = selection.equalsIgnoreCase("N") ? 1 : null;

		while (areaId != null) {
			Room room = roomDataService.read(areaId);
			Map<String, String> search = new HashMap<>();
			search.put("areaAId", String.valueOf(room.getEntityId()));
			List<Path> paths = pathDataService.read(search);

			RichText message = new RichText(room.getContent(), DisplayColor.PURPLE, DisplaySpeed.SLOW);
			display.write(message);

			String input = display.prompt(" > ");

			areaId = null;
			for (Path path : paths) {
				if (path.getNameA().equalsIgnoreCase(input)) {
					areaId = path.getAreaBId();
				}
			}
		}
		 */
		RichText thanks = new RichText("Thanks for playing...", DisplayColor.GREEN, DisplaySpeed.SLOW);
		display.write(thanks);
	}

	private String title(Title title) throws IOException {
		display.write(title.getName());
		display.write("[N]EW GAME");
		display.write("[E]XIT");

		return display.prompt(" > ");
	}
}
