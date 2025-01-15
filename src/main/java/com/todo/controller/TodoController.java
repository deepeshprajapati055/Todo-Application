package com.todo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todo.model.Todo;
import com.todo.service.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/")
	public String todoHome(Model model) {
		List<Todo> todoList = todoService.getAllTodoData();
	    if (todoList == null) {
	        todoList = new ArrayList<>();
	    }
	    model.addAttribute("todo", todoList);
		return "todoindex";
	}
	
	@GetMapping("/gototodo")
	public String gotoTodo() {
		return "addtodo";
	}
	
	@PostMapping("/add")
	public String addTodo(
			@RequestParam("title") String title,
			@RequestParam("date") LocalDate date,
			@RequestParam("time") LocalTime time,
			RedirectAttributes redirectAttributes
			) {
		
		Todo td = new Todo(title, date, time);
		todoService.addTodo(td);
		return "redirect:/";
	}
	
	@GetMapping("/deletetodo/{id}")
	public String deleteTodo(@PathVariable("id") Integer id, Model model) {
		Optional<Todo> td = Optional.ofNullable(todoService.getTodoById(id));
		if(td.isEmpty()) {
			model.addAttribute("error", "Task "+td.get().getId()+" not found.");
			return "todoindex";
		}else {
			todoService.deleteTodoById(id);
			model.addAttribute("message","Task "+td.get().getId()+" deleted successfully.");
			return "todoindex";
		}
	}
	
}
