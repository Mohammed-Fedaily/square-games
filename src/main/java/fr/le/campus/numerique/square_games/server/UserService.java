package fr.le.campus.numerique.square_games.server;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto createUser(UserEntity user);
    List<UserDto> getAllUsers();
    Optional<UserDto> getUserById(String userId);
    void deleteUser(String userId);
}