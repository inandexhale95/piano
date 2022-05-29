package com.devlog.piano.member.domain;

import com.devlog.piano.board.domain.Board;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = "boardList")
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<Board> boardList = new ArrayList<>();
}
