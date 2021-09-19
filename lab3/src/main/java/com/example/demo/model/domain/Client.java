package com.example.demo.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Client {

    public Client(String eMail, String login, String fullName){
        this.eMail = eMail;
        this.login = login;
        this.fullName = fullName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String eMail;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String fullName;

}
