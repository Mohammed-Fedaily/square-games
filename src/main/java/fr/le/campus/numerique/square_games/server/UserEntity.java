package fr.le.campus.numerique.square_games.server;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private String id;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    public UserEntity() {
        this.id = UUID.randomUUID().toString();
    }

    public UserEntity(String email, String password) {
        this();
        this.email = email;
        this.password = password;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}