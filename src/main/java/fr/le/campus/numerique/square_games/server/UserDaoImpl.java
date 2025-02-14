
package fr.le.campus.numerique.square_games.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository repository;

    @Override
    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(String userId) {
        return repository.findById(userId);
    }


}