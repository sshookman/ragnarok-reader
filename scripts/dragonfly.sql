DELETE FROM title;
DELETE FROM entity;
DELETE FROM room;

INSERT INTO title (id, name, tags) VALUES (1, "The Dragonfly Experiments", "survival horror mystery");

INSERT INTO entity (id) VALUES (1);
INSERT INTO room (id, name, content, entityId) VALUES (1, "Room 404", "You are standing in a dark room...", 1);