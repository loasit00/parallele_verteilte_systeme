package com.example.demo;

import java.io.Serializable;

public class Todo implements Serializable{

    public String content;
    public Boolean completed = Boolean.FALSE;
    
    public Todo(){}

    public Todo(String content){
        this.content = content;
    }  
    
   public Todo(String content, Boolean completed) {
        this.content = content;
        this.completed = completed;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todo [todo=" + content + ", completed=" + completed + "]";
    }
    
}
