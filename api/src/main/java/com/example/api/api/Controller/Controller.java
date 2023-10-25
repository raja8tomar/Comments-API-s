package com.example.api.api.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.api.Entity.comment;
import com.example.api.api.Entity.user;
import com.example.api.api.Repository.commentRepo;
import com.example.api.api.Service.userService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private userService userService;
    

    @Autowired
    private commentRepo commentRepo;
    
    //addcomment API
    @PostMapping("/addComment")
    public String addComment(@Valid @RequestBody user user){
         //comment comment=new comment();
         comment comment=user.getComment();
        
         comment.setUser(user);
         user.setComment(comment);
          userService.create(user);
          return "Comment Added Successfully";
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Object>> getComment(@PathVariable int id){
       
       //System.out.println(list); 

       
       return ResponseEntity.ok(commentRepo.getComment(id));
    }

}
