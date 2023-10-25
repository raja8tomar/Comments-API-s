package com.example.api.api.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class user {
    @Id
    private int fromUserId;

    
    @Column(name = "commentFrom")
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]$",
            message = "cannot be Empty and not contains special characters")
    private String commentFrom;

    @Column(name = "commentTo")
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]$",
            message = "cannot be empty and not contains special characters")
    private String commentTo;

   // @OneToOne(cascade = CascadeType.ALL)
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private comment comment;




}
