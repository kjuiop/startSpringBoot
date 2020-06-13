package com.springboot.study.startSpringBoot.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode(of = "memberId")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String username;
    private String password;
    private String name;

    private LocalDateTime regDate;
    private LocalDateTime updateDate;

}
