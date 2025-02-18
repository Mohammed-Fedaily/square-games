package fr.le.campus.numerique.square_games.server;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserCreationParams params) {
        User user = new User(params.getEmail(), params.getPassword());
        User created = userService.createUser(user);
        return new UserDto(created.getId(), created.getEmail());
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        return new UserDto(user.getId(), user.getEmail());
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDto> userDtos = new ArrayList<>();

        for (User user : users) {
            userDtos.add(new UserDto(user.getId(), user.getEmail()));
        }

        return userDtos;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}