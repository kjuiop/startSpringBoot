package com.springboot.study.startSpringBoot.repository;

import com.springboot.study.startSpringBoot.model.Board;
import com.springboot.study.startSpringBoot.model.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
public interface ProfileRepository extends CrudRepository<Profile, Long>, QuerydslPredicateExecutor<Board> {
}
