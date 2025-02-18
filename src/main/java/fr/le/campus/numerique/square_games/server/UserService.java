package fr.le.campus.numerique.square_games.server;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    User getUserById(String id);
    List<User> getAllUsers();
    void deleteUser(String id);
}
