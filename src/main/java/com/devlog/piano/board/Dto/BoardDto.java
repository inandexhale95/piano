package com.devlog.piano.board.Dto;

import com.devlog.piano.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDto {

    private Long seq;

    @NotBlank(message = "제목은 필수 입력 값입니다.")
    @Length(min = 3, max = 50)
    private String title;

    @NotBlank(message = "내용은 필수 입력 값입니다.")
    @Length(min = 3, max = 50)
    private String content;

}
