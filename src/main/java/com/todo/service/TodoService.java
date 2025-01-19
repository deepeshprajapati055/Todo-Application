package com.todo.service;

import java.util.List;

import com.todo.model.Todo;

public interface TodoService {

	Todo addTodo(Todo todo);
	
	List<Todo> getAllTodoData();
	
	void deleteTodoById(Integer id);
	
	Todo getTodoById(Integer id);
	
	Todo updateTodo(Todo todo);
	
	public void save(Todo todo);

}
