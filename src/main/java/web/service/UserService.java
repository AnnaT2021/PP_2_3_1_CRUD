package web.service;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

@Component
public interface UserService {

    void add(User user);
    void update(int id, User user);
    void delete(int id);
    User getUserByID(int id);
    List<User> allUsers();
}
