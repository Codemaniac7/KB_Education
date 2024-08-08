package org.scoula.board.mapper;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.domain.BoardVO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={RootConfig.class})
@Log4j
public class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;

    @Test
    @DisplayName("BoardMapper의 목록 불러오기")
    public void getList() {
        for(BoardVO board:mapper.getList()) {
            log.info(board);
        }
    }

    @Test
    @DisplayName("BoardMapper의 게시글 읽기")
    public void get() {
        // 존재하는 게시물 번호로 테스트
        BoardVO board = mapper.get(1L);
        log.info(board);
    }

    @Test
    @DisplayName("BoardMapper의 새 글 작성")
    public void create() {
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("user0");

        mapper.create(board);

        log.info(board);
    }
}