package com.example.distributed_systems_todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.*;
import java.util.stream.Collectors;


@RestController
public class TodosController {

	private List<Todo> todoList = new ArrayList<>();

	@RequestMapping("/")
	public String welcome() {
		return "Todo App Esslingen SS23";
	}

	@GetMapping("/todo") 
	public List<Todo> getTodos() {
		return todoList;
	}

    @GetMapping("/todo/{todoId}")
	public Todo getTodoByID(@PathVariable int todoId){
		Todo tmpTodo = new Todo();

		for(Todo todo : todoList){
			if(todo.getId() == todoId){
				return todo;
			}
		}
		return tmpTodo;
	}

	@PostMapping("/todo")
	public Todo createTodo(@RequestBody Todo newTodo) {
		todoList.add(newTodo);
        return newTodo;
	}

	@PutMapping("/todo/{todoId}")
	public Todo updateTodo(@PathVariable int todoId, @RequestBody Todo updateTodo) {
		Todo tmpTodo = new Todo();

		for(Todo todo : todoList){
			if(todo.getId() == todoId){
				todo.setId(updateTodo.id);
				todo.setContent(updateTodo.content);
				todo.setCompleted(updateTodo.completed);
				return todo;
			}
		}
		return tmpTodo;
	}

	@DeleteMapping("/todo/{todoId}")
	public String deleteTodo(@PathVariable int todoId) {
		for(Todo todo : todoList){
			if(todo.getId() == todoId){
				todoList.remove(todo);
				return "todo successfully deleted";
			}
		}
		return "no todo with this id";
	}

}