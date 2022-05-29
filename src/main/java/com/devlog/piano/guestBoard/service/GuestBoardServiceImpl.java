package com.devlog.piano.guestBoard.service;

import com.devlog.piano.guestBoard.domain.GuestBoard;
import com.devlog.piano.guestBoard.repository.GuestBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class GuestBoardServiceImpl implements GuestBoardService{

    private GuestBoardRepository guestBoardRepository;

    @Autowired
    public GuestBoardServiceImpl(GuestBoardRepository guestBoardRepository) {
        this.guestBoardRepository = guestBoardRepository;
    }

    @Override
    public Page<GuestBoard> getGuestBoardList() {
        Pageable pageable = PageRequest.of(0, 20, Sort.Direction.DESC, "seq");
        return guestBoardRepository.findAll(pageable);
    }

    @Override
    public void writeGuestBoard(GuestBoard guestBoard) {
        guestBoardRepository.save(guestBoard);
    }

    @Override
    public void deleteGuestBoard(GuestBoard guestBoard) throws Exception {
        GuestBoard findGuestBoard = guestBoardRepository.findById(guestBoard.getSeq()).get();

        if (findGuestBoard.getPassword().equals(guestBoard.getPassword())) {
            guestBoardRepository.deleteById(findGuestBoard.getSeq());
        } else {
            throw new Exception("비밀번호가 틀립니다.");
        }
    }
}
