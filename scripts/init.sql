CREATE TABLE title (
	id integer PRIMARY KEY,
	name text NOT NULL,
	tags text NOT NULL
);

CREATE TABLE chapter (
    id integer PRIMARY KEY,
    title text NOT NULL,
    content text,
    startRoomId integer NOT NULL,

    FOREIGN KEY (startRoomId) REFERENCES room (id)
);

CREATE TABLE room (
    id integer PRIMARY KEY,
    chapterId integer NOT NULL,
    name text NOT NULL,
    content text NOT NULL,

    FOREIGN KEY (chapterId) REFERENCES chapter (id),
);

CREATE TABLE path (
    id integer PRIMARY KEY,
    name text NOT NULL,
    roomId integer NOT NULL,
    destRoomId integer NOT NULL,

    FOREIGN KEY (roomId) REFERENCES room (id),
    FOREIGN KEY (destRoomId) REFERENCES room (id)
);
