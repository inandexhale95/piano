package com.devlog.piano.board.service;

import com.devlog.piano.board.domain.Board;
import com.devlog.piano.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

    private BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Page<Board> getBoardList() {
        Pageable pageable = PageRequest.of(0, 20, Sort.Direction.DESC, "seq");
        return boardRepository.findAll(pageable);
    }

    @Override
    public Board getBoard(long seq) {
        return boardRepository.findById(seq).get();
    }

    @Override
    public void writeBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public void updateBoard(Board board) {
        Board findBoard = boardRepository.findById(board.getSeq()).get();

        findBoard.setContent(board.getContent());
        boardRepository.save(findBoard);
    }

    @Override
    public void deleteBoard(long seq) {
        boardRepository.deleteById(seq);
    }
}
