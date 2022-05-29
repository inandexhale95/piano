package com.devlog.piano;

import com.devlog.piano.board.domain.Board;
import com.devlog.piano.board.repository.BoardRepository;
import com.devlog.piano.guestBoard.domain.GuestBoard;
import com.devlog.piano.guestBoard.repository.GuestBoardRepository;
import com.devlog.piano.member.domain.Member;
import com.devlog.piano.member.domain.Role;
import com.devlog.piano.member.repository.MemberRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataInitialize {

    private BoardRepository boardRepository;
    private MemberRepository memberRepository;
    private GuestBoardRepository guestBoardRepository;

    @Autowired
    public DataInitialize(BoardRepository boardRepository,
                          MemberRepository memberRepository,
                          GuestBoardRepository guestBoardRepository) {
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
        this.guestBoardRepository = guestBoardRepository;
    }

    @Test
    public void testSeedData() {
        Member member1 = new Member();
        member1.setId("user1");
        member1.setPassword("user123");
        member1.setName("기본맨");
        member1.setRole(Role.ROLE_MEMBER);
        member1.setEnabled(true);
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setId("admin1");
        member2.setPassword("admin123");
        member2.setName("관리자");
        member2.setRole(Role.ROLE_ADMIN);
        member2.setEnabled(true);
        memberRepository.save(member2);

        for (int i = 1; i <= 7; i++) {
            Board board = new Board();
            board.setContent(member1.getName() + "이 작성한 게시물 " + i);
            board.setMember(member1);
            boardRepository.save(board);
        }

        for (int i = 1; i <= 7; i++) {
            Board board = new Board();
            board.setContent(member2.getName() + "이 작성한 게시물 " + i);
            board.setMember(member2);
            boardRepository.save(board);
        }

        for (int i = 1; i <= 10; i++) {
            GuestBoard guestBoard = new GuestBoard();
            guestBoard.setName(member1.getName()+i);
            guestBoard.setPassword("123");
            guestBoard.setContent(member1.getName() + i + "가 작성한 게시물");
            guestBoardRepository.save(guestBoard);
        }
    }
}
