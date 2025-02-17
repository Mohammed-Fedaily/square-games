package fr.le.campus.numerique.square_games.server;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(@Qualifier("jdbcUserDao") UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID().toString());
        }
        return userDao.save(user);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public Optional<UserEntity> getUserById(String userId) {
        return userDao.findById(userId);
    }

    @Override
    public void deleteUser(String userId) {
        userDao.delete(userId);
    }
}