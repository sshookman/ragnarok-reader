package codepoet.ragnarok.reader.dbo;

import codepoet.vaultmonkey.annotations.SqliteColumn;
import codepoet.vaultmonkey.annotations.SqliteObject;

@SqliteObject(table = "path")
public class Path {

	@SqliteColumn
	private Integer id;
	@SqliteColumn
	private String name;
	@SqliteColumn
	private Integer roomId;
	@SqliteColumn
	private Integer destRoomId;

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

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getDestRoomId() {
		return destRoomId;
	}

	public void setDestRoomId(Integer destRoomId) {
		this.destRoomId = destRoomId;
	}
}
