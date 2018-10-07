DELETE FROM title;
DELETE FROM chapter;
DELETE FROM room;
DELETE FROM path;

INSERT INTO title (id, name, tags)
VALUES (1, "The Dragonfly Experiments", "survival horror mystery");

INSERT INTO chapter (id, name, content)
VALUES (1, "Shadows Come Out to Play", "You awake to a pounding headache...");

INSERT INTO entity (id)
VALUES (1);

INSERT INTO entity (id)
VALUES (2);

INSERT INTO entity (id)
VALUES (3);

INSERT INTO room (id, entityId, chapterId, name, content)
VALUES (1, 1, 1, "Room 404", "You are standing in a dark room...");

INSERT INTO room (id, entityId, chapterId, name, content)
VALUES (2, 2, 1, "Upper Hallway", "The hallway is lit with a line of candles...");

INSERT INTO path (id, entityId, chapterId, name, roomId, destRoomId)
VALUES (1, 3, 1, "North Door", 1, 2);
