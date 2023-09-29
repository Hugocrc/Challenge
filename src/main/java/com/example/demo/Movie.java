package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private String date;
    @Column(name = "rating")
    private String rating;
    @Column(name = "revenue")
    private String revenue;

    // Construtor padrão sem argumentos
    public Movie() {}

    // Construtor com parâmetros
    public Movie(int id, String name, String date, String rating, String revenue) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.rating = rating;
        this.revenue = revenue;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getRating() {
        return rating;
    }

    public String getRevenue() {
        return revenue;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }
}