package pl.warehouse.database.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import pl.warehouse.database.IUserDAO;
import pl.warehouse.models.User;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class UserDAO implements IUserDAO {

    private final SessionFactory sessionFactory;

    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteUser(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(getUserById(id));
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public User getUserByUsername(String username) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.warehouse.models.User WHERE username = :username");
        query.setParameter("username", username);
        try {
            User user = query.getSingleResult();
            session.close();
            return user;
        } catch (NoResultException e) {
            session.close();
            return null;
        }
    }

    @Override
    public List<User> getUserList() {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.warehouse.models.User");
        List<User> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.warehouse.models.User WHERE id = :id");
        query.setParameter("id", id);
        try {
            User user = query.getSingleResult();
            session.close();
            return user;
        } catch (NoResultException e) {
            session.close();
            return null;
        }
    }
}
