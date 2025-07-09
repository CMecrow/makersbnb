package com.makers.makersbnb.model;

import jakarta.persistence.*;

// @Entity - instances of this class map to database records
@Entity
// @Table - those records can be found in the spaces table
@Table(name = "STAFF")
public class Staff {
    // the following field (id) is the primary key for this Entity
    @Id
    // the value of id is generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // a second field that holds the name, description and price of each space
    private String name;
    private String role;

    // a zero-arguments constructor
    public Staff() {}
    // a one-argument constructor
    public Staff(String name, String role) {
        this.name = name;
        this.role = role;
    }
    // methods that get and set name
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    // methods that get and set role
    public String getRole() { return this.role; }
    public void setRole(String role) { this.role = role; }

}

