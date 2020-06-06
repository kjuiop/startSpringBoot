package com.springboot.study.startSpringBoot.controller;

import com.springboot.study.startSpringBoot.dto.PostsSaveRequestDto;
import com.springboot.study.startSpringBoot.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("api/v1/posts")
public class PostsApiController {

    private final PostsService postsService;

    @PutMapping()
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }
}
