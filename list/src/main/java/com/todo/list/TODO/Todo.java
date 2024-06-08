package com.todo.list.TODO;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_sequence_generator")
    @SequenceGenerator(
        sequenceName = "todo_sequence",
        initialValue = 5,
        name = "todo_sequence_generator"
    )
    private int id;
    private String username;
    @Size(min=10,message = "Enter at least 10 characters")
    private String description;
    private LocalDate localdate;
    private boolean done;

    public Todo(){
    }

    // Constructor without ID
    public Todo(String username, String description, LocalDate localdate, Boolean done) {
        this.username = username;
        this.description = description;
        this.localdate = localdate;
        this.done = done;
    }

    public Todo(int id, String username, String description, LocalDate localdate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.localdate = localdate;
        this.done = done;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setLocaldate(LocalDate localdate) {
        this.localdate = localdate;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getLocaldate() {
        return localdate;
    }
    public boolean isDone() {
        return done;
    }
    @Override
    public String toString() {
        return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", localdate=" + localdate
                + ", done=" + done + "]";
    }
    
    
}
