package fr.le.campus.numerique.square_games.server;

import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.*;

@Component("jdbcUserDao")
public class JdbcUserDao implements UserDao {
    private final NamedParameterJdbcTemplate database;

    public JdbcUserDao(NamedParameterJdbcTemplate database) {
        this.database = database;
    }

    @Override
    public List<UserEntity> findAll() {
        String query = "SELECT * FROM users";
        return database.query(query, (resultSet, rowNum) -> {
            UserEntity user = new UserEntity();
            user.setId(resultSet.getString("id"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            return user;
        });
    }

    @Override
    public Optional<UserEntity> findById(String userId) {
        String query = "SELECT * FROM users WHERE id = :id";

        Map<String, Object> params = Collections.singletonMap("id", userId);

        List<UserEntity> users = database.query(
                query,
                params,
                (resultSet, rowNum) -> {
                    UserEntity user = new UserEntity();
                    user.setId(resultSet.getString("id"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    return user;
                }
        );

        return users.stream().findFirst();
    }

    @Override
    @Transactional
    public UserEntity save(UserEntity user) {
        String sql = "INSERT INTO users (id, email, password) " +
                "VALUES (:id, :email, :password) " +
                "ON DUPLICATE KEY UPDATE " +
                "email = :email, password = :password";

        Map<String, Object> params = new HashMap<>();
        params.put("id", user.getId());
        params.put("email", user.getEmail());
        params.put("password", user.getPassword());

        database.update(sql, params);
        return user;
    }

    @Override
    @Transactional
    public void delete(String userId) {
        String query = "DELETE FROM users WHERE id = :id";
        Map<String, Object> params = Collections.singletonMap("id", userId);
        database.update(query, params);
    }
}