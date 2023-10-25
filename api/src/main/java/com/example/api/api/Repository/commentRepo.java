package com.example.api.api.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.example.api.api.Entity.comment;

public interface commentRepo extends JpaRepository<comment,Integer>{
     
    @Query("select c.message from comment c where c.toUserId= ?1")
    public  List<Object> getComment(int id);
}
 
