DROP TABLE IF EXISTS TBL_BOARD;

CREATE TABLE TBL_BOARD (
    NO INTEGER AUTO_INCREMENT PRIMARY KEY,
    TITLE VARCHAR(200) NOT NULL,
    CONTENT TEXT,
    WRITER VARCHAR(50) NOT NULL,
    REG_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
    UPDATE_DATE DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO TBL_BOARD(title, content, writer)
VALUES ('테스트 제목1', '테스트 내용1', 'user00'),
       ('테스트 제목2', '테스트 내용2', 'user00'),

       ('테스트 제목3', '테스트 내용3', 'user00'),
       ('테스트 제목4', '테스트 내용4', 'user00'),
       ('테스트 제목5', '테스트 내용5', 'user00');

SELECT * FROM TBL_BOARD;