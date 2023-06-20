package com.example.demo;

import java.io.Serializable;

public class Todo implements Serializable{

    public String content;
    public int priority = 2;
    
    public Todo(){}

    public Todo(String content) {
        this.content = content;
    }    
    
    public Todo(String content, int priority) {
        this.content = content;
        this.priority = priority;
    }

    public String getContent() {
        return content;
    }

    public int getPriority() {
        return priority;
    }
    
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Todo [content=" + content + ", priority=" + priority + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Todo other = (Todo) obj;
        if (content == null) {
            if (other.content != null)
                return false;
        } else if (!content.equals(other.content))
            return false;
        return true;
    }
    
}
