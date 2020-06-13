package com.springboot.study.startSpringBoot.controller;

import com.springboot.study.startSpringBoot.model.Member;
import com.springboot.study.startSpringBoot.model.Profile;
import com.springboot.study.startSpringBoot.repository.MemberRepository;
import com.springboot.study.startSpringBoot.repository.ProfileRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Commit
public class ProfileTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProfileRepository profileRepository;


    @Test
    public void testInsertMember() {



        for (int i=1; i<5; i++) {
            Member member = new Member();
            member.setUsername("user" + i);
            member.setPassword("password" + "i");
            member.setName("사용자" + i);

            memberRepository.save(member);
        }
    }

    @Test
    public void testInsertProfile() {
        Optional<Member> optMember = memberRepository.findById(1L);

        for (int i=1; i<5; i++) {
            Profile profile = new Profile();
            profile.setFilename("face" + i + ".jpg");

            if (i == 1) {
                profile.setCurrent(true);
            }
            profile.setMember(optMember.get());
            profileRepository.save(profile);
        }
    }
}
