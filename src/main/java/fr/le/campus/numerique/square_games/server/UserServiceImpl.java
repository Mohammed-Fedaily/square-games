package fr.le.campus.numerique.square_games.server;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(@Qualifier("userDaoImpl") UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDto createUser(UserEntity user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID().toString());
        }
        UserEntity savedUser = userDao.save(user);
        return new UserDto(savedUser.getId(), savedUser.getEmail());
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userDao.findAll().stream()
                .map(user -> new UserDto(user.getId(), user.getEmail()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> getUserById(String userId) {
        return userDao.findById(userId)
                .map(user -> new UserDto(user.getId(), user.getEmail()));
    }

    @Override
    public void deleteUser(String userId) {
        userDao.delete(userId);
    }
}