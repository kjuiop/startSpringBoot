package com.springboot.study.startSpringBoot.controller;

import com.springboot.study.startSpringBoot.model.Board;
import com.springboot.study.startSpringBoot.repository.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void inspect() {
        Class<?> clz = boardRepository.getClass();

        System.out.println(clz.getName());

        Class<?>[] interfaces = clz.getInterfaces();

        Stream.of(interfaces).forEach(inter -> System.out.println(inter.getName()));

        Class<?> superClasses = clz.getSuperclass();

        System.out.println(superClasses.getName());
    }

    @Test
    public void testInsert() {
        Board board = new Board();
        board.setTitle("제목..2");
        board.setContent("게시물의 내용 넣기...");
        board.setWriter("user00");
        board.setCreatedAt(LocalDateTime.now());
        board.setUpdatedAt(LocalDateTime.now());

        boardRepository.save(board);
    }

    @Test
    public void testRead() {
        boardRepository.findById(1L).ifPresent((board -> {
            System.out.println(board);
        }));
    }

    @Test
    public void testUpdate() {

        System.out.println("Update Title................................");
        Optional<Board> optBoard = boardRepository.findById(1L);
        Board board = optBoard.get();
        board.setTitle("제목..1");

        System.out.println("Call Save()");
        boardRepository.save(board);
    }

    @Test
    public void testDelete() {
        System.out.println("DELETE Entity ");
        Optional<Board> optBoard = boardRepository.findById(1L);
        Board board = optBoard.get();

        boardRepository.delete(board);
    }

    @Test
    public void testByTitle() {
        boardRepository.findBoardByTitle("제목..1").forEach(System.out::println);
    }

    @Test
    public void testByWriter() {
        Collection<Board> results = boardRepository.findByWriter("user00");

        results.forEach(
                System.out::println
        );
    }
}
