package codepoet.ragnarok.reader.dbo;

import codepoet.vaultmonkey.annotations.SqliteColumn;
import codepoet.vaultmonkey.annotations.SqliteObject;

@SqliteObject(table = "path")
public class Path {

	@SqliteColumn
	private Integer id;
	@SqliteColumn
	private Integer entityId;
	@SqliteColumn
	private String nameA;
	@SqliteColumn
	private String nameB;
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

	public String getNameA() {
		return nameA;
	}

	public void setNameA(String nameA) {
		this.nameA = nameA;
	}

	public String getNameB() {
		return nameB;
	}

	public void setNameB(String nameB) {
		this.nameB = nameB;
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
