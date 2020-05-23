package com.springboot.study.startSpringBoot.repository;

import com.springboot.study.startSpringBoot.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * @author Jake
 * @date: 20/04/01
 */
@Transactional(readOnly = true)
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findBoardByTitle(String title);

    Collection<Board> findByWriter(String writer);
}