package com.devlog.piano.board.controller;

import com.devlog.piano.board.domain.Board;
import com.devlog.piano.board.service.BoardService;
import com.devlog.piano.board.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/")
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardServiceImpl boardServiceImpl) {
        this.boardService = boardServiceImpl;
    }

    @GetMapping("/list")
    public String getBoardList(Model model) {
        Page<Board> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "board/list";
    }
}
