package com.example.demo;

import java.io.Serializable;

public class Todo implements Serializable{

    public Long id;
    public String content;
    public Boolean completed = Boolean.FALSE;
    
    public Todo(){}

    public Todo(Long id){
        this.id = id;
    }

    public Todo(String content){
        this.content = content;
    }  
    
   public Todo(String content, Boolean completed ) {
        this.content = content;
        this.completed  = completed ;
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

    public Boolean getcompleted () {
        return completed ;
    }

    public void setcompleted (Boolean completed ) {
        this.completed  = completed ;
    }

    @Override
    public String toString() {
        return "Todo [todo=" + content + ", completed =" + completed  + "]";
    }
    
}
