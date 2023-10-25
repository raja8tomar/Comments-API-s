package com.example.api.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.api.Entity.user;
import com.example.api.api.Repository.userRepo;

@Service
public class userService{
    
    @Autowired
    private userRepo userRepo;

    public user create(user user){

        return userRepo.save(user);
    }
    
    
    
}
