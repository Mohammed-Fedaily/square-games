package fr.le.campus.numerique.square_games.server;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<UserEntity> findAll();
    Optional<UserEntity> findById(String userId);
//    UserEntity save(UserEntity user);
//    void delete(String userId);
}