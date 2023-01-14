package com.day5.day5.data;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String username;

    private String password;

    public String getUsername() {
        return this.username;
    }

    public void hashPassword() {
        if (this.password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        this.password = this.password.hashCode() + ":" + this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return this.id;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password.hashCode() + ":" + password);
    }
}
