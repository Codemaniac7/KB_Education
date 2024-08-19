package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    private final BoardService service;

    @GetMapping("")
//    public List<BoardDTO> getList() {
//        return service.getList();
//    }
    public ResponseEntity<List<BoardDTO>> getList() {
         try{
             return ResponseEntity.ok(service.getList());
         } catch (NoSuchElementException e){
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body(null); // 또는 적절한 에러 메시지 설정
         }
    }

    @GetMapping("/{no}")
    public ResponseEntity<BoardDTO> get(@PathVariable Long no) {
        try {
            BoardDTO board = service.get(no);
            return ResponseEntity.ok(board);
        } catch (NoSuchElementException e) {
            log.error("데이터를 찾을 수 없습니다. ID: {}", no, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // 또는 적절한 에러 메시지 설정
        }
    }

    @PostMapping("")
    public ResponseEntity<BoardDTO> create(@RequestBody BoardDTO board) {
        return ResponseEntity.ok(service.create(board));
    }

    @PutMapping("/{no}")
    public ResponseEntity<BoardDTO> update(@PathVariable("no") int id, @RequestBody BoardDTO board) {
        return ResponseEntity.ok(service.update(board));
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<?> delete(@PathVariable Long no) {
//        return ResponseEntity.ok(service.delete(no));
        service.delete(no);
        return ResponseEntity.ok().build();
    }
}
