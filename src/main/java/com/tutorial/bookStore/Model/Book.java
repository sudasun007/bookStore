package com.tutorial.bookStore.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private String author;
    private String price;

    public Book(String name, String author, String price, int id) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.id = id;
    }

    public Book() {
        super();
    }
}
