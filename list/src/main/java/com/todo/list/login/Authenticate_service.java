package com.todo.list.login;

import org.springframework.stereotype.Service;

@Service
public class Authenticate_service {
    
    public boolean authenticate(String name,String password){
        boolean isvaliduser=name.equalsIgnoreCase("kesh");
        boolean isvalidpass=password.equalsIgnoreCase("23456");
      return isvaliduser && isvalidpass;
    }
}
