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
	private String tag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}
