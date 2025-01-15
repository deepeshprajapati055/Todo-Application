package com.todo.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String todoHome() {
		return "todoindex";
	}
	
	@GetMapping("/gototodo")
	public String gotoTodo() {
		return "addtodo";
	}
	
	@PostMapping("/add")
	public String addTodo(
			@RequestParam("title") String title,
			@RequestParam("LocalDate") LocalDate date,
			@RequestParam("LocalTime") LocalTime time,
			RedirectAttributes redirectAttributes
			) {
		
		Todo td = new Todo(title, date, time);
		todoService.addTodo(td);
		return "redirect:/";
	}
}
