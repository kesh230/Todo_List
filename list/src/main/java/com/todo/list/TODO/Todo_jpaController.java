package com.todo.list.TODO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@SessionAttributes("name")
public class Todo_jpaController {

    // private Todo_service service;

    private Todo_repository repository;
    
    public Todo_jpaController(Todo_repository repository) {
        // this.service = service;
        this.repository=repository;
    }

    private String getloggedinUsername(ModelMap model) {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
          return authentication.getName();
        }
    @GetMapping("/todo")
    public String todo(ModelMap model){
        String username=getloggedinUsername(model);
        List<Todo> todo=repository.findByUsername(username);
        
        model.addAttribute("todo", todo);
           return "todo";
    }

   @GetMapping("/add-todo")
    public String shownewtodo(ModelMap model){
        String username=getloggedinUsername(model);
        Todo todo=new Todo(username,"", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);  
        return "addtodo";
    }
    @PostMapping("/add-todo")
    public String addtodo(ModelMap model,@Valid Todo todo,BindingResult result){
        if(result.hasErrors()){
            return "addtodo";
        }
         String username=getloggedinUsername(model);
         todo.setUsername(username);
         repository.save(todo);
        //  service.addtodo(username, todo.getDescription(),todo.getLocaldate(), false);
           return "redirect:todo";
    }
    @RequestMapping("/delete-todo")
    public String delete(@RequestParam int id){
        repository.deleteById(id);
        return "redirect:todo";
    }
    @GetMapping("/update-todo")
    public String update(@RequestParam int id,ModelMap model){
        Todo todo=repository.findById(id).get();
         model.addAttribute("todo",todo);
        return "addtodo";
    }
    @PostMapping("/update-todo")
    public String updatetodo(ModelMap model,@Valid Todo todo,BindingResult result){
        if(result.hasErrors()){
            return "addtodo";
        }
         String username=getloggedinUsername(model);
         todo.setUsername(username);
        //  service.updatetodo(todo);
         repository.save(todo);
           return "redirect:todo";
    }
}

