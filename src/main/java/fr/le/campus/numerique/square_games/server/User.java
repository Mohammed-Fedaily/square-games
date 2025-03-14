package fr.le.campus.numerique.square_games.server;
import java.util.UUID;

public class User {
    private String id;
    private String email;

    private String password;

    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public User(String email, String password) {
        this.id = UUID.randomUUID().toString();
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