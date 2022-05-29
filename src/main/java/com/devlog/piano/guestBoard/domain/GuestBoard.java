package com.devlog.piano.guestBoard.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class GuestBoard {
    @Id
    @GeneratedValue
    private Long seq;

    private String name;

    private String password;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createDate = new Date();
}
