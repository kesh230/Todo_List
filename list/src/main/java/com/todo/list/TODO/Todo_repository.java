package com.todo.list.TODO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Todo_repository extends JpaRepository<Todo,Integer> {
   public List<Todo> findByUsername(String username);
}

