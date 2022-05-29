package com.devlog.piano.guestBoard.service;

import com.devlog.piano.guestBoard.domain.GuestBoard;
import org.springframework.data.domain.Page;

public interface GuestBoardService {
    Page<GuestBoard> getGuestBoardList();
    void writeGuestBoard(GuestBoard guestBoard);
    void deleteGuestBoard(GuestBoard guestBoard) throws Exception;
}
