package com.example.distributed_systems_todoapp;

import jakarta.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    
    public String content;
    public int priority = 2;

    public Todo() {}

    public Todo(Long id, String content, int priority ) {
        this.id = id;
        this.content = content;
        this.priority  = priority ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPriority () {
        return priority ;
    }

    public void setPriority (int priority ) {
        this.priority  = priority ;
    }
}