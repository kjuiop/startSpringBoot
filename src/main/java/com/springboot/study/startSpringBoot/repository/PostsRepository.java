package com.springboot.study.startSpringBoot.repository;

import com.springboot.study.startSpringBoot.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jake
 * @date: 20/04/01
 */
@Transactional(readOnly = true)
@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
