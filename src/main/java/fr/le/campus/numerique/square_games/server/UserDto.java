package fr.le.campus.numerique.square_games.server;

public class UserDto {
    private final String id;
    private final String email;

    public UserDto(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
