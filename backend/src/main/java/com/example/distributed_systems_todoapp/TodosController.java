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
import org.springframework.web.bind.annotation.PutMapping;
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
		todoRepository.findAll().forEach(todo -> allTodos.add(todo));
		return allTodos;
	}

	@GetMapping("/todo/{id}")
	public Todo getTodoById(@PathVariable Long id){
		Optional<Todo> oTodo = todoRepository.findById(id);

		if(oTodo.isPresent()){
			return oTodo.get();
		}
		else
		{
			return null;
		}
	}

	@PostMapping("/todo")
	public Todo addNewTodo(@RequestBody Todo newItem){
		return todoRepository.save(newItem);
	}

	@PutMapping("/todo/{id}")
	public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo){
		Optional<Todo> oTodo = todoRepository.findById(id);

		if(oTodo.isPresent()){
			oTodo.get().setContent(todo.content);
			oTodo.get().setPriority (todo.priority );
			return todoRepository.save(oTodo.get());
		}
		else
		{
			return null;
		}
	}

	@DeleteMapping("/todo/{id}")
	public void removeTodo(@PathVariable Long id){
		Optional<Todo> oTodo = todoRepository.findById(id);

		if(oTodo.isPresent()){
			todoRepository.deleteById(id);
		}
	}

	@DeleteMapping("/todo")
	public void removeAllTodos(){
		todoRepository.deleteAll();
	}
}