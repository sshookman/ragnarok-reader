package codepoet.ragnarok.reader;

import java.sql.Connection;

import codepoet.ragnarok.reader.dbo.Chapter;
import codepoet.ragnarok.reader.dbo.Room;
import codepoet.ragnarok.reader.dbo.Title;
import codepoet.vaultmonkey.service.SqliteDataService;
import codepoet.vaultmonkey.util.SqliteConnectionUtil;

class StoryService {

	private SqliteDataService<Title> titleDataService;
	private SqliteDataService<Chapter> chapterDataService;
	private SqliteDataService<Room> roomDataService;

	public StoryService(final String archive) throws Exception {
		final Connection connection = SqliteConnectionUtil.establishConnection(archive);
		this.titleDataService = new SqliteDataService<>(Title.class, connection);
		this.chapterDataService  = new SqliteDataService<>(Chapter.class,  connection);
		this.roomDataService  = new SqliteDataService<>(Room.class,  connection);
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
}
