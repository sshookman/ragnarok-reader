package codepoet.ragnarok.reader.dbo;

import codepoet.vaultmonkey.annotations.SqliteColumn;
import codepoet.vaultmonkey.annotations.SqliteObject;

@SqliteObject(table = "chapter")
public class Chapter {

	@SqliteColumn
	private Integer id;
	@SqliteColumn
	private String name;
	@SqliteColumn
	private String content;
	@SqliteColumn
	private Integer startRoomId;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStartRoomId() {
		return startRoomId;
	}

	public void setStartRoomId(Integer startRoomId) {
		this.startRoomId = startRoomId;
	}
}
