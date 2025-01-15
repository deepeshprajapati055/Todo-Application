package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.model.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Integer>{

}
