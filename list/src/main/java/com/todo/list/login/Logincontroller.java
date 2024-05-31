package com.todo.list.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class Logincontroller {
     @Autowired
     private Authenticate_service au_service;

    @RequestMapping(value="login",method=RequestMethod.GET)
    public String login(){
       return "login";
    }
    @RequestMapping(value="login",method=RequestMethod.POST)
    public String home(@RequestParam String username,String pass,ModelMap model){
      if(au_service.authenticate(username, pass)){
      model.put("name",username);
      model.put("password",pass);
       return "home";
    }
    else{
      model.put("errorMessage","nikl laude galat hai");
      return "login";
    }
   
}
}
