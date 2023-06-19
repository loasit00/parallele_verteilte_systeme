package com.example.demo;

import java.io.Serializable;

public class Todo implements Serializable{

    public String content;
    public int priority;
    
    public Todo(){}

    public Todo(String content){
        this.content = content;
    }  
    
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

    public int getpriority () {
        return priority ;
    }

    public void setpriority (int priority ) {
        this.priority  = priority ;
    }

    @Override
    public String toString() {
        return "Todo [todo=" + content + ", priority =" + priority  + "]";
    }
    
}
