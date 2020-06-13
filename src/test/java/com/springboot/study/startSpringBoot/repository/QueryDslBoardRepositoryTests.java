package com.springboot.study.startSpringBoot.repository;

import com.querydsl.core.BooleanBuilder;
import com.springboot.study.startSpringBoot.model.Board;
import com.springboot.study.startSpringBoot.model.QBoard;
import com.springboot.study.startSpringBoot.repository.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryDslBoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testPredicate() {

        String type = "t";
        String keyword = "17";

        BooleanBuilder builder = new BooleanBuilder();

        QBoard board = QBoard.board;

        builder.and(board.title.like("%" + keyword + "%"));

        builder.and(board.bno.gt(0L));

        Pageable pageable = PageRequest.of(0, 10);
        Page<Board> result = boardRepository.findAll(builder, pageable);

        System.out.println("PAGE SIZE : " + result.getSize());
        System.out.println("TOTAL PAGES : " + result.getTotalPages());
        System.out.println("TOTAL COUNT : " + result.getTotalElements());
        System.out.println("NEXT : " + result.nextPageable());

        List<Board> list = result.getContent();
        list.forEach(System.out::println);

    }
}
