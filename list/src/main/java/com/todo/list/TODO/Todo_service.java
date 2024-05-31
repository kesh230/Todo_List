package com.todo.list.TODO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// import org.apache.taglibs.standard.extra.spath.Predicate;
// import org.springframework.beans.factory.annotation.Autowired;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class Todo_service {

   private static int count=0;  
   private static List<Todo> todos=new ArrayList<>();
   static{
        todos.add(new Todo(++count, "jack23", "AWS Practitioner", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++count, "ravan23", "Java core", LocalDate.now().plusYears(2), true));
   } 
   public List<Todo> findByUsername(String username){
    return todos;
   }
   public void addtodo(String username,String description,LocalDate targetDate,boolean done){
    Todo todo=new Todo(++count, username, description, targetDate, done);
    todos.add(todo);
   }
   public void deletebyId(int id){
   Predicate<? super Todo> predicate=todo->todo.getId()==id;
   todos.removeIf(predicate);
   }
}
