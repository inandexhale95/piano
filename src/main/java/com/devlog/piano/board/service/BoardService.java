package com.devlog.piano.board.service;

import com.devlog.piano.board.domain.Board;
import org.springframework.data.domain.Page;

public interface BoardService {
    Page<Board> getBoardList();
    Board getBoard(long seq);
    void writeBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(long seq);
}
