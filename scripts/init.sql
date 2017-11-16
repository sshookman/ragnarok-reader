DROP TABLE IF EXISTS title;
DROP TABLE IF EXISTS chapter;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS path;

CREATE TABLE title (
	id integer PRIMARY KEY,
	name text NOT NULL,
	tags text NOT NULL
);

CREATE TABLE chapter (
    id integer PRIMARY KEY,
    name text NOT NULL,
    content text NOT NULL
);

CREATE TABLE room (
    id integer PRIMARY KEY,
    chapterId integer NOT NULL,
    name text NOT NULL,
    content text NOT NULL,

    FOREIGN KEY (chapterId) REFERENCES chapter (id)
);

CREATE TABLE path (
    id integer PRIMARY KEY,
    chapterId integer NOT NULL,
    name text NOT NULL,
    roomId integer NOT NULL,
    destRoomId integer NOT NULL,

    FOREIGN KEY (chapterId) REFERENCES chapter (id),
    FOREIGN KEY (roomId) REFERENCES room (id),
    FOREIGN KEY (destRoomId) REFERENCES room (id)
);
