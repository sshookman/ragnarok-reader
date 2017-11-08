package codepoet.ragnarok.reader;

import java.sql.Connection;
import java.util.ArrayList;

import codepoet.ragnarok.reader.bo.RoomExpanded;
import codepoet.ragnarok.reader.dbo.Room;
import codepoet.ragnarok.reader.dbo.Title;
import codepoet.vaultmonkey.service.SqliteDataService;
import codepoet.vaultmonkey.util.SqliteConnectionUtil;

class StoryService {

	private SqliteDataService<Title> titleDataService;
	private SqliteDataService<Room> roomDataService;

	public StoryService(final String archive) throws Exception {
		final Connection connection = SqliteConnectionUtil.establishConnection(archive);
		this.titleDataService = new SqliteDataService<>(Title.class, connection);
		this.roomDataService  = new SqliteDataService<>(Room.class,  connection);
	}
	
	public Title getTitle() {
		return titleDataService.read(1);
	}
	
	public RoomExpanded getRoom(final int roomId) {
		Room room = roomDataService.read(roomId);
		return new RoomExpanded(room, new ArrayList<>());
	}
}
