package codepoet.ragnarok.reader.dbo;

import codepoet.vaultmonkey.annotations.SqliteColumn;
import codepoet.vaultmonkey.annotations.SqliteObject;

@SqliteObject(table = "title")
public class Title {

	@SqliteColumn
	private Integer id;
	@SqliteColumn
	private String name;
	@SqliteColumn
	private String tags;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTags() {
		return tags;
	}

	public void setTag(String tags) {
		this.tags = tags;
	}
}
