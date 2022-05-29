package com.devlog.piano.guestBoard.repository;

import com.devlog.piano.guestBoard.domain.GuestBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestBoardRepository extends JpaRepository<GuestBoard, Long> {
}
