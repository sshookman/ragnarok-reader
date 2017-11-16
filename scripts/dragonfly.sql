DELETE FROM title;
DELETE FROM chapter;
DELETE FROM room;
DELETE FROM path;

INSERT INTO title (id, name, tags) VALUES (1, "The Dragonfly Experiments", "survival horror mystery");

INSERT INTO chapter (id, name, content) VALUES (1, "Shadows Come Out to Play", "You awake to a pounding headache...");
INSERT INTO room (id, chapterId, name, content) VALUES (1, 1, "Room 404", "You are standing in a dark room...");
INSERT INTO room (id, chapterId, name, content) VALUES (2, 1, "Upper Hallway", "The hallway is lit with a line of candles...");
INSERT INTO path (id, chapterId, name, roomId, destRoomId) VALUES (1, 1, "North Door", 1, 2);