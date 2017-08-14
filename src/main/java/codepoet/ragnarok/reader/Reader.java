package codepoet.ragnarok.reader;

import codepoet.ragnarok.reader.bo.Area;
import codepoet.ragnarok.reader.bo.Path;
import codepoet.ragnarok.reader.display.DisplayColor;
import codepoet.ragnarok.reader.display.DisplayInterface;
import codepoet.ragnarok.reader.display.DisplaySpeed;
import codepoet.ragnarok.reader.display.RichText;
import codepoet.vaultmonkey.service.SqliteDataService;
import codepoet.vaultmonkey.util.SqliteConnectionUtil;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reader {

	private final SqliteDataService<Area> areaDataService;
	private final SqliteDataService<Path> pathDataService;
	private final DisplayInterface display;

	public Reader(final DisplayInterface display, final String archive) throws Exception {
		this.display = display;
		Connection connection = SqliteConnectionUtil.establishConnection(archive);
		this.areaDataService = new SqliteDataService<>(Area.class, connection);
		this.pathDataService = new SqliteDataService<>(Path.class, connection);
	}

	public void read() throws IOException {

		Integer areaId = 1;

		while (areaId != null) {
			Area area = areaDataService.read(areaId);
			Map<String, String> search = new HashMap<>();
			search.put("areaAId", String.valueOf(area.getEntityId()));
			List<Path> paths = pathDataService.read(search);

			RichText message = new RichText(area.getDescription(), DisplayColor.PURPLE, DisplaySpeed.SLOW);
			display.write(message);

			String input = display.prompt(" > ");

			areaId = null;
			for (Path path : paths) {
				if (path.getName().equalsIgnoreCase(input)) {
					areaId = path.getAreaBId();
				}
			}
		}

		RichText theEnd = new RichText("THE END", DisplayColor.RED, DisplaySpeed.SLOW);
		display.write(theEnd);
	}
}
