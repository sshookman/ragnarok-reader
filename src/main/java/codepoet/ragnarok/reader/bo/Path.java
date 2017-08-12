package codepoet.ragnarok.reader.bo;

import codepoet.vaultmonkey.annotations.SqliteColumn;
import codepoet.vaultmonkey.annotations.SqliteObject;

@SqliteObject(table = "path")
public class Path {

	@SqliteColumn
	private Integer id;
	@SqliteColumn
	private Integer entityId;
	@SqliteColumn
	private String name;
	@SqliteColumn
	private Integer areaAId;
	@SqliteColumn
	private Integer areaBId;

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

	public Integer getAreaAId() {
		return areaAId;
	}

	public void setAreaAId(Integer areaAId) {
		this.areaAId = areaAId;
	}

	public Integer getAreaBId() {
		return areaBId;
	}

	public void setAreaBId(Integer areaBId) {
		this.areaBId = areaBId;
	}
}
