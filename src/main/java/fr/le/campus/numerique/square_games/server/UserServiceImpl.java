package fr.le.campus.numerique.square_games.server;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final Map<String, UserDto> users = new HashMap<>();

    @Override
    public UserDto createUser(UserCreationParams params) {
        String userId = UUID.randomUUID().toString();
        UserDto newUser = new UserDto(userId, params.getEmail());
        users.put(userId, newUser);
        return newUser;
    }

    @Override
    public UserDto getUser(String userId) {
        return users.get(userId);
    }
}