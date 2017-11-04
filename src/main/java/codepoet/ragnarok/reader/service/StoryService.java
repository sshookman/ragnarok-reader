package codepoet.ragnarok.reader.service;

import codepoet.ragnarok.reader.dbo.Chapter;
import codepoet.ragnarok.reader.dbo.Path;
import codepoet.ragnarok.reader.dbo.Room;
import codepoet.ragnarok.reader.dbo.Title;
import codepoet.vaultmonkey.service.SqliteDataService;
import codepoet.vaultmonkey.util.SqliteConnectionUtil;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class StoryService {

	private final SqliteDataService<Title> titleDS;
	private final SqliteDataService<Chapter> chapterDS;
	private final SqliteDataService<Room> roomDS;
	private final SqliteDataService<Path> pathDS;

	public StoryService(final String archive) throws Exception {
		Connection connection = SqliteConnectionUtil.establishConnection(archive);
		this.titleDS = new SqliteDataService<>(Title.class, connection);
		this.chapterDS = new SqliteDataService<>(Chapter.class, connection);
		this.roomDS = new SqliteDataService<>(Room.class, connection);
		this.pathDS = new SqliteDataService<>(Path.class, connection);
	}

	public Title getTitle() {
		return titleDS.read(1);
	}

	public Chapter getChapter(final Integer ind) {
		Map<String, String> search = new HashMap<>();
		search.put("ind", String.valueOf(ind));
		return (Chapter) chapterDS.read(search);
	}

	public Room getRoom(final Integer id) {
		Room room = roomDS.read(id);
		return room;
	}
}
