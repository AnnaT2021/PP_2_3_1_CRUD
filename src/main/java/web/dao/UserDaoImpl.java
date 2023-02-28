package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public void add(User user){
        entityManager.merge(user);
    }

    @Override
    public void update(Long id, User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(Long id){
        return entityManager.find(User.class, id);
    }
    @Override
    public void delete(Long id){
        entityManager.remove(getById(id));
    }

  @Override
  @SuppressWarnings("unchecked")
   public List<User> allUsers(){
      return entityManager.createQuery("FROM User", User.class).getResultList();
      }
}
