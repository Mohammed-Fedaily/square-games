package fr.le.campus.numerique.square_games.server;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;

@Component
public class UserDaoImpl implements UserDao {
    private final UserRepository userRepository;

    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (user.getEmail() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("Email and password cannot be null");
        }
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        UserEntity savedEntity = userRepository.save(entity);
        return new User(savedEntity.getEmail(), savedEntity.getPassword());
    }

    @Override
    public User findById(String id) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new User(entity.getEmail(), entity.getPassword());
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> entities = userRepository.findAll();
        List<User> users = new ArrayList<>(entities.size());
        for (UserEntity entity : entities) {
            users.add(new User(entity.getEmail(), entity.getPassword()));
        }
        return users;
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }
}