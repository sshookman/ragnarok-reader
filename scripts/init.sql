CREATE TABLE entity (
    id integer PRIMARY KEY
);

CREATE TABLE title (
	id integer PRIMARY KEY,
	name text NOT NULL,
	tags text NOT NULL
);

CREATE TABLE chapter (
    id integer PRIMARY KEY,
    title text NOT NULL,
    content text,
    entityId integer NOT NULL UNIQUE,

    FOREIGN KEY (entityId) REFERENCES entity (id)
);

CREATE TABLE room (
    id integer PRIMARY KEY,
    name text NOT NULL,
    content text NOT NULL,
    entityId integer NOT NULL UNIQUE,

    FOREIGN KEY (entityId) REFERENCES entity (id)
);

CREATE TABLE path (
    id integer PRIMARY KEY,
    roomAId integer NOT NULL,
    roomBId integer NOT NULL,
    entityId integer NOT NULL UNIQUE,

    FOREIGN KEY (entityId) REFERENCES entity (id)
    FOREIGN KEY (roomAId) REFERENCES entity (id)
    FOREIGN KEY (roomBId) REFERENCES entity (id)
);
