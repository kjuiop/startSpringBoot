package com.springboot.study.startSpringBoot.repository;

import com.springboot.study.startSpringBoot.model.Board;
import com.springboot.study.startSpringBoot.repository.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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
        board.setTitle("제목..1");
        board.setContent("게시물의 내용 넣기...");
        board.setWriter("user00");
        board.setCreatedAt(LocalDateTime.now());
        board.setUpdatedAt(LocalDateTime.now());

        boardRepository.save(board);
    }

    @Test
    public void testRead() {
        boardRepository.findById(1L).ifPresent((System.out::println));
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

    @Test
    public void testInsert200() {
        for (int i = 1; i<=200; i++) {
            Board board = new Board();
            board.setTitle("제목.." + i);
            board.setContent("내용 ..." + i + " 채우기 ");
            board.setWriter("user0" + (i % 10));

            boardRepository.save(board);
        }
    }

    @Test
    public void testByWriterContaining() {
        Collection<Board> results = boardRepository.findByWriterContaining("05");
        results.forEach(System.out::println);
    }

    @Test
    public void testByTitleAndBno() {
        Collection<Board> results = boardRepository.findByTitleContainingAndBnoGreaterThan("5", 50L);
        results.forEach(System.out::println);
    }

    @Test
    public void testBnoOrderByPaging() {
        Pageable paging = PageRequest.of(0, 10);
        Collection<Board> results = boardRepository.findByBnoGreaterThanOrderByBnoDesc(0L, paging);
        results.forEach(System.out::println);
    }

    @Test
    public void testBnoPagingSort() {
        Pageable paging = PageRequest.of(0, 10, Sort.Direction.ASC, "bno");

        Page<Board> result = boardRepository.findByBnoGreaterThan(0L, paging);
        System.out.println("PAGE SIZE : " + result.getSize());
        System.out.println("TOTAL PAGES : " + result.getTotalPages());
        System.out.println("TOTAL COUNT : " + result.getTotalElements());
        System.out.println("NEXT : " + result.nextPageable());

        List<Board> list = result.getContent();
        list.forEach(System.out::println);
    }


    @Test
    public void testByTitle2() {
        boardRepository.findByTitle("17").forEach(System.out::println);
    }

    @Test
    public void testByContent() {
        boardRepository.findByContent("17").forEach(System.out::println);
    }

    @Test
    public void testByWriter2() {
        Collection<Board> results = boardRepository.findByWriter2("user00");

        results.forEach(
                System.out::println
        );
    }


    @Test
    public void testByTitle3() {
        boardRepository.findByTitle2("17").forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}
