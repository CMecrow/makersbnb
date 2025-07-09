package com.makers.makersbnb.model;

import jakarta.persistence.*;

// @Entity - instances of this class map to database records
@Entity
// @Table - those records can be found in the spaces table
@Table(name = "SPACES")
public class Space {
    // the following field (id) is the primary key for this Entity
    @Id
    // the value of id is generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // a second field that holds the name, description and price of each space
    private String name;
    private String description;
    private Integer price;
    private String rules;
    // a zero-arguments constructor
    public Space() {}
    // a one-argument constructor
    public Space(String name, String description, Integer price, String rules) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.rules = rules;
    }
    // methods that get and set name
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    // methods that get and set description
    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }
    // methods that get and set price
    public Integer getPrice() { return this.price; }
    public void setPrice(Integer price) { this.price = price; }
    // methods that get and set rules
    public String getRules() { return this.rules; }
    public void setRules(String rules) { this.rules = rules; }
}
