package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public void add(User user){
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserByID(int id){
     return entityManager.find(User.class, id);
    }

    @Override
    public void delete(int id){
        entityManager.remove(getUserByID(id));
    }

  @Override //done
  @SuppressWarnings("unchecked")
   public List<User> allUsers(){
      List<User> userList = entityManager
              .createQuery("FROM User", User.class).getResultList();
      return userList;
      }
}
