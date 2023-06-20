package com.example.distributed_systems_todoapp;

import jakarta.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {

    @Id    
    public String content;
    public int priority = 2;

    public Todo() {}

    public Todo(String content, int priority ) {
        this.content = content;
        this.priority  = priority ;
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