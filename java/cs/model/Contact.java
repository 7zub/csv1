package cs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Contact")
public class Contact {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;

    public Contact(){}

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
}