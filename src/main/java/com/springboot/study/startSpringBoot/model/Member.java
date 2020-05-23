package com.springboot.study.startSpringBoot.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Member {

    private Long memberId;
    private String title;
    private String writer;
    private String content;

    private LocalDateTime regDate;
    private LocalDateTime updateDate;

}
