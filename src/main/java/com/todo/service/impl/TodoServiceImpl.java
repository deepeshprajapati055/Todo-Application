package com.todo.service.impl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Todo> getAllTodoData() {
		return this.todoRepo.findAll();
	}

	@Override
	public Todo getTodoById(Integer id) {
		Optional<Todo> td = this.todoRepo.findById(id);
		if(td.isEmpty()) {
			return null;
		}else {
			return td.get();
		}
	}

	@Override
	public void deleteTodoById(Integer id) {
		todoRepo.deleteById(id);
	}

	@Override
	public Todo updateTodo(Todo todo) {
		Optional<Todo> td = this.todoRepo.findById(todo.getId());
		if(td.isEmpty()) {
			return null;
		}else {
			return todoRepo.save(todo);
		}
	}

}

