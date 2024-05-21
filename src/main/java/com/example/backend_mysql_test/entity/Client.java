package com.example.backend_mysql_test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal participation;

    public Client(String firstName, String lastName, BigDecimal participation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.participation = participation;
    }

    public Client() {
    }
}
