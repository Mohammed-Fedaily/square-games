package fr.le.campus.numerique.square_games.server;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    User save(User user);
    User findById(String id);
    List<User> findAll();
    void delete(String id);
}