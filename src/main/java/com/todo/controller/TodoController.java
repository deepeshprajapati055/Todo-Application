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
	
	@PostMapping("/add")
	public String addTodo(
			@RequestParam("title") String title,
			@RequestParam("date") LocalDate date,
			@RequestParam("time") LocalTime time,
			@RequestParam("status") String status,
			RedirectAttributes redirectAttributes
			) {
		
		Todo td = new Todo(title, date, time, status);
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
	
	@GetMapping("/updateTodo/{id}")
	public String updateTodoList(@PathVariable("id") Integer id, Model model) {
		Optional<Todo> td = Optional.ofNullable(todoService.getTodoById(id));
		if(td.isEmpty()) {
			model.addAttribute("error", "Task "+td.get().getId()+" not updated.");
			return "todoindex";
		}else {
			model.addAttribute("todo", td.get());
		}
		return "updatetodo";
	}
	
	@PostMapping("/updateTask/{id}")
	public String updateTodoList(
			@PathVariable("id") Integer id,
			@RequestParam("title") String title,
			@RequestParam("date") LocalDate date,
			@RequestParam("time") LocalTime time,
			@RequestParam("status") String status,
			RedirectAttributes redirectAttributes
			) {
		Optional<Todo> td = Optional.ofNullable(todoService.getTodoById(id));
		if(td.isEmpty()) {
			return null;
		}else {
			td.get().setId(id);
			td.get().setTitle(title);
			td.get().setDate(date);
			td.get().setTime(time);
			td.get().setStatus(status);
			todoService.addTodo(td.get());
		}
		return "redirect:/";
	}
}
