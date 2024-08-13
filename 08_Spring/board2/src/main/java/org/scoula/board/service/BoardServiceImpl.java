package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.mapper.BoardMapper;
import org.scoula.dto.BoardDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    final private BoardMapper mapper;

    @Override
    public List<BoardDTO> getList() {
        log.info("getList..........");

        return mapper.getList().stream()
                .map(BoardDTO::of)
                .toList();
    }


    @Override
    public void create(BoardDTO board) {
        log.info("create......." + board);

        BoardVO boardVO= board.toVO();
        mapper.create(board.toVO());

    }

    @Override
    public boolean update(BoardDTO board) {
        log.info("update..........." + board);

        return mapper.update(board.toVO()) == 1;
    }

    @Override
    public boolean delete(Long no) {
        log.info("delete...." + no);

        return mapper.delete(no) == 1;
    }
}
