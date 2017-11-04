package codepoet.ragnarok.reader.dbo;

import codepoet.vaultmonkey.annotations.SqliteColumn;
import codepoet.vaultmonkey.annotations.SqliteObject;

@SqliteObject(table = "room")
public class Room {

	@SqliteColumn
	private Integer id;
	@SqliteColumn
	private Integer entityId;
	@SqliteColumn
	private String name;
	@SqliteColumn
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
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
}
