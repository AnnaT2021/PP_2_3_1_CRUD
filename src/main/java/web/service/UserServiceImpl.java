package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;
import web.service.UserService;

import java.util.List;
//import web.model.User;


@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void add(User user){
        userDao.add(user);
    }
    @Override
    @Transactional
    public void update(Long id, User user) {
        userDao.update(id, user);
    }
    @Override
    @Transactional
    public void delete(Long id){
        userDao.delete(id);
    }
    @Override
    @Transactional(readOnly = true)
    public User getById(Long id){
        return userDao.getById(id);
    }
   @Override
   @Transactional(readOnly = true)
   public List<User> allUsers(){
     return userDao.allUsers();
 }
}
