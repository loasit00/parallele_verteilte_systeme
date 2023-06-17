package com.example.distributed_systems_todoapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TodosController {

	@Autowired
	TodoRepository todoRepository;

	@RequestMapping("/")
	public String welcome() {
		return "Todo App Esslingen SS23";
	}

	@GetMapping("/todo")
	public List<Todo> getAllTodos(){
		List<Todo> allTodos = new ArrayList<Todo>();
		todoRepository.findAll().forEach(todo -> allTodos.add(todo)).orElseThrow(() -> new NoSuchElementException("There are no todos"));
		return allTodos;
	}

	@GetMapping("/todo/{id}")
	public Todo getTodoById(@PathVariable int idTodo){
		return todoRepository.findById(idTodo).get().orElseThrow(() -> new NoSuchElementException("Todo not found"));
	}

	@PostMapping("/todo")
	public Todo addNewTodo(@RequestBody Todo newItem){
		return todoRepository.save(newItem);
	}

	@DeleteMapping("/todo")
	public void removeTodo(@RequestBody Todo todo){
		todoRepository.delete(todo);
	}
}