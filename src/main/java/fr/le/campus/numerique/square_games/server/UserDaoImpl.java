package fr.le.campus.numerique.square_games.server;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {
    private final UserRepository repository;

    public UserDaoImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(String userId) {
        return repository.findById(userId);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return repository.save(user);
    }

    @Override
    public void delete(String userId) {
        repository.deleteById(userId);
    }
}