package codepoet.ragnarok.reader.bo;

import codepoet.ragnarok.reader.dbo.Path;
import codepoet.ragnarok.reader.dbo.Room;
import java.util.List;

public class RoomExpanded {

	private final Integer id;
	private final Integer entityId;
	private final String name;
	private final String content;
	private final List<Path> paths;

	public RoomExpanded(final Room room, List<Path> paths) {
		this.id = room.getId();
		this.entityId = room.getEntityId();
		this.name = room.getName();
		this.content = room.getContent();
		this.paths = paths;
	}

	public Integer getId() {
		return id;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public List<Path> getPaths() {
		return paths;
	}
}
