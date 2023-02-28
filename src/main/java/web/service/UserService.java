package web.service;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

@Component
public interface UserService {

    void add(User user);
    void update(Long id, User user);
    void delete(Long id);
    User getById(Long id);
    List<User> allUsers();
}