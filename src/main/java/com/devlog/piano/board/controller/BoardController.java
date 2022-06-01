package com.devlog.piano.board.controller;

import com.devlog.piano.board.domain.Board;
import com.devlog.piano.board.service.BoardService;
import com.devlog.piano.board.service.BoardServiceImpl;
import com.devlog.piano.security.config.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/detail")
    public String getBoardDetail(long seq, Model model) {
        Board findBoard = boardService.getBoard(seq);
        model.addAttribute("board", findBoard);
        return "board/detail";
    }

    @GetMapping("/write")
    public String writeBoard() {
        return "board/write";
    }

    @PostMapping("/write")
    public String writeBoard(Board board, @AuthenticationPrincipal SecurityUser principal) {
        board.setMember(principal.getMember());
        boardService.writeBoard(board);
        return "redirect:/board/detail?seq=" + board.getSeq();
    }

    @GetMapping("/delete")
    public String deleteBoard(long seq) {
        boardService.deleteBoard(seq);

        return "redirect:/board/list";
    }

    @GetMapping("/update")
    public String updateBoard(long seq, Model model) {
        Board findBoard = boardService.getBoard(seq);
        model.addAttribute("board", findBoard);
        return "board/update";
    }

    @PostMapping("/update")
    public String updateBoard(Board board) {
        Board findBoard = boardService.getBoard(board.getSeq());

        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());
        boardService.updateBoard(findBoard);
        return "redirect:/board/list";
    }
}
