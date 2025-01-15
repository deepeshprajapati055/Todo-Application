package com.todo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.model.Todo;
import com.todo.repository.TodoRepo;
import com.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	TodoRepo todoRepo;
	
	@Override
	public Todo addTodo(Todo todo) {
		return this.todoRepo.save(todo);
	}
	

}
