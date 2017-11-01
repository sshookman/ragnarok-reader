CREATE TABLE entity (
    id integer PRIMARY KEY
);

CREATE TABLE chapter (
    id integer PRIMARY KEY,
    title text NOT NULL,
    content text,
    entity_id integer NOT NULL UNIQUE,

    FOREIGN KEY (entity_id) REFERENCES entity (id)
);

CREATE TABLE room (
    id integer PRIMARY KEY,
    name text NOT NULL,
    content text NOT NULL,
    entity_id integer NOT NULL UNIQUE,

    FOREIGN KEY (entity_id) REFERENCES entity (id)
);

CREATE TABLE path (
    id integer PRIMARY KEY,
    room_a_id integer NOT NULL,
    room_b_id integer NOT NULL,
    entity_id integer NOT NULL UNIQUE,

    FOREIGN KEY (entity_id) REFERENCES entity (id)
    FOREIGN KEY (room_a_id) REFERENCES entity (id)
    FOREIGN KEY (room_b_id) REFERENCES entity (id)
);
