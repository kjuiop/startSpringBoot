package com.springboot.study.startSpringBoot.repository;

import com.springboot.study.startSpringBoot.model.Board;
import com.springboot.study.startSpringBoot.model.Member;
import com.springboot.study.startSpringBoot.model.Profile;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jake
 * @date: 20/04/01
 */
@Transactional(readOnly = true)
@Repository
public interface MemberRepository extends CrudRepository<Member, Long>, QuerydslPredicateExecutor<Board> {
}
