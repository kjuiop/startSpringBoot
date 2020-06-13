package com.springboot.study.startSpringBoot.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(exclude = "member")
@Entity
@EqualsAndHashCode(of = "fno")
public class Profile {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;
    private String filename;
    private Boolean current;

    @ManyToOne
    private Member member;

}
