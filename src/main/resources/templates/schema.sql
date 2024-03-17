CREATE TABLE tbl_board (
                           boardId BIGINT AUTO_INCREMENT PRIMARY KEY,
                           title VARCHAR(30) NOT NULL,
                           content VARCHAR(30) NOT NULL,
                           name VARCHAR(30) NOT NULL,
                           `read` INT NOT NULL DEFAULT 0
);

INSERT INTO tbl_board (title, content, name, `read`)
VALUES
    ('제목1', '내용1', '이름1', 0),
    ('제목2', '내용2', '이름2', 0),
    ('제목3', '내용3', '이름3', 0),
    ('제목4', '내용4', '이름4', 0),
    ('제목5', '내용5', '이름5', 0),
    ('제목6', '내용6', '이름6', 0),
    ('제목7', '내용7', '이름7', 0),
    ('제목8', '내용8', '이름8', 0),
    ('제목9', '내용9', '이름9', 0),
    ('제목10', '내용10', '이름10', 0);
