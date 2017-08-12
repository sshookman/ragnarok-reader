package codepoet.ragnarok.reader;

import codepoet.ragnarok.reader.bo.Area;
import codepoet.ragnarok.reader.bo.Path;
import codepoet.ragnarok.reader.display.DisplayColor;
import codepoet.ragnarok.reader.display.DisplayInterface;
import codepoet.ragnarok.reader.display.DisplaySpeed;
import codepoet.ragnarok.reader.display.RichText;
import codepoet.vaultmonkey.service.SqliteDataService;
import codepoet.vaultmonkey.util.SqliteConnectionUtil;
import java.sql.Connection;

public class Reader {

	private SqliteDataService<Area> areaDataService;
	private SqliteDataService<Path> pathDataService;

	private DisplayInterface display;

	public Reader(final DisplayInterface display, final String archive) throws Exception {
		this.display = display;
		Connection connection = SqliteConnectionUtil.establishConnection(archive);
		this.areaDataService = new SqliteDataService<>(Area.class, connection);
		this.pathDataService = new SqliteDataService<>(Path.class, connection);
	}

	public void read() {

		RichText message = new RichText("Welcome to the Ragnarok Reader", DisplayColor.PURPLE, DisplaySpeed.SLOW);
		display.write(message);
	}
}
