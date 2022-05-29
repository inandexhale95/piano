package com.devlog.piano.guestBoard.controller;

import com.devlog.piano.board.domain.Board;
import com.devlog.piano.guestBoard.domain.GuestBoard;
import com.devlog.piano.guestBoard.repository.GuestBoardRepository;
import com.devlog.piano.guestBoard.service.GuestBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guestBoard/")
public class GuestBoardController {

    private GuestBoardService guestBoardService;

    @Autowired
    public GuestBoardController(GuestBoardService guestBoardService) {
        this.guestBoardService = guestBoardService;
    }

    @GetMapping("/list")
    public String getGuestBoardList(Model model) {
        Page<GuestBoard> guestBoardList = guestBoardService.getGuestBoardList();

        model.addAttribute("guestBoardList", guestBoardList);
        return "guestBoard/list";
    }

    @PostMapping("/write")
    public String writeGuestBoard(GuestBoard guestBoard) {
        guestBoardService.writeGuestBoard(guestBoard);

        return "redirect:list";
    }
}
