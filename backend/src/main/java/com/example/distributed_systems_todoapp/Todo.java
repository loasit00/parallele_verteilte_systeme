package hse.distributedSystems.LabBackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    private String content;
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

    @Override
    public String toString(){
        return content;
    }
    
}
