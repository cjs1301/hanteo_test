INSERT INTO category (name) VALUES ('남자'); -- ID 1
INSERT INTO category (name) VALUES ('여자'); -- ID 2
INSERT INTO category (name) VALUES ('엑소'); -- ID 3
INSERT INTO category (name) VALUES ('방탄소년단'); -- ID 4
INSERT INTO category (name) VALUES ('블랙핑크'); -- ID 5

INSERT INTO board (name) VALUES ('공지사항'); -- ID 1
INSERT INTO board (name) VALUES ('첸'); -- ID 2
INSERT INTO board (name) VALUES ('백현'); -- ID 3
INSERT INTO board (name) VALUES ('시우민'); -- ID 4
INSERT INTO board (name) VALUES ('공지사항'); -- ID 5
INSERT INTO board (name) VALUES ('익명게시판'); -- ID 6
INSERT INTO board (name) VALUES ('뷔'); -- ID 7
INSERT INTO board (name) VALUES ('공지사항'); -- ID 8
INSERT INTO board (name) VALUES ('로제'); -- ID 9
-----------------------------------------------------------------------------------------
INSERT INTO category_relation (parent_idx, child_id) VALUES (1, 3); -- 남자 -> 엑소
INSERT INTO category_relation (parent_idx, child_id) VALUES (1, 4); -- 남자 -> 방탄소년단
INSERT INTO category_relation (parent_idx, child_id) VALUES (2, 5); -- 여자 -> 블랙핑크
------------------------------------------------------------------------------------------
INSERT INTO category_boards (board_id, category_id) VALUES (1, 3); -- 공지사항 -> 엑소
INSERT INTO category_boards (board_id, category_id) VALUES (2, 3); -- 첸 -> 엑소
INSERT INTO category_boards (board_id, category_id) VALUES (3, 3); -- 백현 -> 엑소
INSERT INTO category_boards (board_id, category_id) VALUES (4, 3); -- 시우민 -> 엑소

INSERT INTO category_boards (board_id, category_id) VALUES (5, 4); -- 공지사항 -> 방탄소년단
INSERT INTO category_boards (board_id, category_id) VALUES (6, 4); -- 익명게시판 -> 방탄소년단
INSERT INTO category_boards (board_id, category_id) VALUES (7, 4); -- 뷔 -> 방탄소년단

INSERT INTO category_boards (board_id, category_id) VALUES (8, 5); -- 공지사항 -> 블랙핑크
INSERT INTO category_boards (board_id, category_id) VALUES (6, 5); -- 익명게시판 -> 방탄소년단
INSERT INTO category_boards (board_id, category_id) VALUES (9, 5); -- 로제 -> 방탄소년단


