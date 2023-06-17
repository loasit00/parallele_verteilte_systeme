package com.example.distributed_systems_todoapp;

import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;


@Transactional
public interface TodoRepository extends CrudRepository<Todo, Long>{
    
}