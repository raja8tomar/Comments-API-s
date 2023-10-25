package com.example.api.api.Entity;







import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "commentId")
    private int commentId;

    @Column(name = "message")
    private String message;
    
    @Column(name = "toUserid")
    private int toUserId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date",nullable = false)
    private Date date;

    @PrePersist
    private void onCreate() {
    date = new Date();
}

    

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fromUserId",unique=false)
    private user user;
    
    

     
}
