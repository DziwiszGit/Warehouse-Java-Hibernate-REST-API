package pl.warehouse.database.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.warehouse.database.IAccountDAO;
import pl.warehouse.models.Account;
import pl.warehouse.models.Product;
import pl.warehouse.models.Warehouseman;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class AccountDAO implements IAccountDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addAccount(String login, String password, Warehouseman warehouseman) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(new Account(login,password,warehouseman));
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
    public void deleteAccount(Warehouseman warehouseman) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(getAccountList().equals(warehouseman));
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
    public Account getAccountByLogin(String login) {
        Session session = this.sessionFactory.openSession();
        Query<Account> query = session.createQuery("FROM pl.warehouse.models.Account WHERE login = :login");
        query.setParameter("login", login);
        try {
            Account account = query.getSingleResult();
            session.close();
            return account;
        } catch (NoResultException e) {
            session.close();
            return null;
        }
    }

    @Override
    public List<Account> getAccountList() {
        Session session = this.sessionFactory.openSession();
        Query<Account> query = session.createQuery("FROM pl.warehouse.models.Account");
        List<Account> result = query.getResultList();
        session.close();
        return result;
    }
}
