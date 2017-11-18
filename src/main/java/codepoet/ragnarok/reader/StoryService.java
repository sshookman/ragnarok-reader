package codepoet.ragnarok.reader;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import codepoet.ragnarok.reader.dbo.Chapter;
import codepoet.ragnarok.reader.dbo.Path;
import codepoet.ragnarok.reader.dbo.Room;
import codepoet.ragnarok.reader.dbo.Title;
import codepoet.vaultmonkey.service.SqliteDataService;
import codepoet.vaultmonkey.util.SqliteConnectionUtil;

class StoryService {

	private SqliteDataService<Title> titleDataService;
	private SqliteDataService<Chapter> chapterDataService;
	private SqliteDataService<Room> roomDataService;
	private SqliteDataService<Path> pathDataService;

	public StoryService(final String archive) throws Exception {
		final Connection connection = SqliteConnectionUtil.establishConnection(archive);
		this.titleDataService = new SqliteDataService<>(Title.class, connection);
		this.chapterDataService  = new SqliteDataService<>(Chapter.class,  connection);
		this.roomDataService  = new SqliteDataService<>(Room.class,  connection);
		this.pathDataService  = new SqliteDataService<>(Path.class,  connection);
	}
	
	public Title getTitle() {
		return titleDataService.read(1);
	}
	
	public Chapter getChapter(final int chapterId) {
		return chapterDataService.read(chapterId);
	}
	
	public Room getRoom(final int roomId) {
		return roomDataService.read(roomId);
	}
	
	public Path getPath(final Integer roomId, final String name) {
		Path path = null;
		Map<String, String> search = new HashMap<>();
		search.put("roomId", roomId.toString());
		search.put("name", "\"" + name + "\"");
		
		List<Path> paths = pathDataService.read(search);
		if (paths != null && !paths.isEmpty()) {
			path = paths.get(0);
		}
		
		return path;
	}
}
