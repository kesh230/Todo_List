package com.todo.list.TODO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// import org.apache.taglibs.standard.extra.spath.Predicate;
// import org.springframework.beans.factory.annotation.Autowired;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

import jakarta.validation.Valid;

// @Component
public class Todo_service {

   private static int count=0;  
   private static List<Todo> todos=new ArrayList<>();
   static{
        todos.add(new Todo(++count, "kesh", "AWS Practitioner 1", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++count, "kesh", "Java core 1", LocalDate.now().plusYears(2), true));
   } 
   public List<Todo> findByUsername(String username){
   Predicate<? super Todo> predicate=todo->todo.getUsername().equalsIgnoreCase(username);
    return todos.stream().filter(predicate).toList();
   }
   public void addtodo(String username,String description,LocalDate targetDate,boolean done){
    Todo todo=new Todo(++count, username, description, targetDate, done);
    todos.add(todo);
   }
   public void deletebyId(int id){
   Predicate<? super Todo> predicate=todo->todo.getId()==id;
   todos.removeIf(predicate);
   }
   public Todo findbyId(int id) {
      Predicate<? super Todo> predicate=todo->todo.getId()==id;   
      Todo todo= todos.stream().filter(predicate).findFirst().get();
      return todo;
   }
   public void updatetodo(@Valid Todo todo) {
       deletebyId(todo.getId());
       todos.add(todo);
   }
}
