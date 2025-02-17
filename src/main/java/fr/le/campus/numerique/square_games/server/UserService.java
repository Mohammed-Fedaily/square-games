package fr.le.campus.numerique.square_games.server;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserEntity createUser(UserEntity user);
    List<UserEntity> getAllUsers();
    Optional<UserEntity> getUserById(String userId);
    void deleteUser(String userId);
}
