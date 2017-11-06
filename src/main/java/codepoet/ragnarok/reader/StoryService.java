package codepoet.ragnarok.reader;

import java.sql.Connection;

import codepoet.ragnarok.reader.dbo.Title;
import codepoet.vaultmonkey.service.SqliteDataService;
import codepoet.vaultmonkey.util.SqliteConnectionUtil;

class StoryService {

	private SqliteDataService<Title> titleDataService;

	public StoryService(final String archive) throws Exception {
		Connection connection = SqliteConnectionUtil.establishConnection(archive);
		this.titleDataService = new SqliteDataService<>(Title.class, connection);
	}
	
	public Title getTitle() {
		return titleDataService.read(1);
	}
}
