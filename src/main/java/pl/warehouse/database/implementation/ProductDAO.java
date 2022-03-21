package pl.warehouse.database.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.warehouse.database.IProductDAO;
import pl.warehouse.models.Product;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class ProductDAO implements IProductDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addProduct(Product product) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(product);
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
    public void deleteProductById(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(getProductById(id));
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
    public List<Product> getProductList() {
        Session session = this.sessionFactory.openSession();
        Query<Product> query = session.createQuery("FROM pl.warehouse.models.Product");
        List<Product> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public Product getProductById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Product> query = session.createQuery("FROM pl.warehouse.models.Product WHERE id = :id");
        query.setParameter("id", id);
        try {
            Product product = query.getSingleResult();
            session.close();
            return product;
        } catch (NoResultException e) {
            session.close();
            return null;
        }
    }

    @Override
    public void uppdateWeight(Product product) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            if(product.getWeight()>0){
                session.update(product);
            }
            else{
                session.delete(product);
            }
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}
