package io.github.dannyprojrct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.dannyprojrct.model.ToDo;

@Repository
public interface ToDoRepository  extends JpaRepository<ToDo, Long> {

}
