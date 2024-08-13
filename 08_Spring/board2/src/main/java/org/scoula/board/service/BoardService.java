package org.scoula.board.service;

import org.scoula.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> getList();

    public void create(BoardDTO board);

    public boolean update(BoardDTO board);

    public boolean delete(Long no);
}
