package codepoet.ragnarok.reader.bo;

public class Path {

	private Integer id;
	private Integer entityId;
	private String name;
	private Integer areaAId;
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
