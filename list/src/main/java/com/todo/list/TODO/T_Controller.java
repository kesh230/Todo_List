package com.todo.list.TODO;

import java.time.LocalDate;
import java.util.List;

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
public class T_Controller {

    private Todo_service service;
    
    public T_Controller(Todo_service service) {
        this.service = service;
    }

    @GetMapping("/todo")
    public String todo(ModelMap model){
        List<Todo> todo=service.findByUsername("jack23");
        model.addAttribute("todo", todo);
           return "todo";
    }
    @GetMapping("/add-todo")
    public String shownewtodo(ModelMap model){
        String username=(String)model.get("username");
        Todo todo=new Todo(0, username,"", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);  
        return "addtodo";
    }
    @PostMapping("/add-todo")
    public String addtodo(ModelMap model,@Valid Todo todo,BindingResult result){
        if(result.hasErrors()){
            return "addtodo";
        }
         String username=(String)model.get("username");
         service.addtodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
           return "redirect:todo";
    }
    @RequestMapping("/delete-todo")
    public String delete(@RequestParam int id){
        service.deletebyId(id);
        return "redirect:todo";
    }
}
