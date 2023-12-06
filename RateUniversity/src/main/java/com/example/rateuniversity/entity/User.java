package com.example.rateuniversity.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 45, name = "username")
    private String username;

    @Column(nullable = false, length = 15)
    private String password;

    private String dateCreated;
    private String displayPictureColor;

    private boolean admin = false;
    private boolean banned = false;

    public boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(boolean status) {
        this.admin = status;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
