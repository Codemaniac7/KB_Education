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

SELECT * FROM TBL_BOARD ORDER BY NO DESC;

DROP TABLE IF EXISTS tbl_board_attachment;
CREATE TABLE tbl_board_attachment (
                                      no INTEGER AUTO_INCREMENT PRIMARY KEY,
                                      filename VARCHAR(256) NOT NULL, -- 원본 파일 명
                                      path VARCHAR(256) NOT NULL, -- 서버에서의 파일 경로
                                      content_type VARCHAR(56), -- content-type
                                      size INTEGER, -- 파일의 크기
                                      bno INTEGER NOT NULL, -- 게시글 번호, FK
                                      reg_date DATETIME DEFAULT now(),
                                      CONSTRAINT FOREIGN KEY(bno) REFERENCES tbl_board(no)
);