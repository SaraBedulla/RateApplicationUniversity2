package com.example.rateuniversity.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;

    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;

    @NotEmpty
    @Column(unique = true)
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String dateCreated;
   // private String displayPictureColor;

    private boolean admin = false;
    private boolean banned = false;

    public boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(boolean status) {
        this.admin = status;
    }
}
