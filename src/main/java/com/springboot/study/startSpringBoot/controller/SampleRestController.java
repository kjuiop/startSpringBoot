package com.springboot.study.startSpringBoot.controller;

import com.springboot.study.startSpringBoot.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class SampleRestController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/sample")
    public MemberDto makeMemberDto() {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(1L);
        memberDto.setName("김정인");
        memberDto.setUserName("kjuiop");
        memberDto.setNickName("Jake");

        return memberDto;
    }
}
