package com.todo.list.hello;

import org.springframework.stereotype.Controller;
// import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HController {
    
    @ResponseBody
    @RequestMapping("say")
    public String sayhello(){
       return "ha bhai kya haal";
    }
    @RequestMapping("sayhello")
    public String sayhello1(){
       return "hello";
    }
    
}
