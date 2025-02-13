package fr.le.campus.numerique.square_games.server;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;


public class UserCreationParams {
    private final @NotNull @Email String email;
    private final @NotEmpty String password;

    public UserCreationParams(@NotNull @Email String email, @NotEmpty String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

