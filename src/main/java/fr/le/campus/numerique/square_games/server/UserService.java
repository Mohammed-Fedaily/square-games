package fr.le.campus.numerique.square_games.server;

public interface UserService {
    UserDto createUser(UserCreationParams params);
    UserDto getUser(String userId);
}
