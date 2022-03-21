package pl.warehouse.database.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.warehouse.database.IWarehousemenDAO;
import pl.warehouse.models.Product;
import pl.warehouse.models.Warehouseman;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class WarehousemenDAO implements IWarehousemenDAO {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List<Warehouseman> getWarehousemenList() {
        Session session = this.sessionFactory.openSession();
        Query<Warehouseman> query = session.createQuery("FROM pl.warehouse.models.Warehouseman");
        List<Warehouseman> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public Warehouseman getWarehousemenByID(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Warehouseman> query = session.createQuery("FROM pl.warehouse.models.Warehouseman WHERE id = :id");
        query.setParameter("id", id);
        try {
            Warehouseman warehouseman = query.getSingleResult();
            session.close();
            return warehouseman;
        } catch (NoResultException e) {
            session.close();
            return null;
        }
    }
    public void addWarehouseman(Warehouseman warehouseman) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(warehouseman);
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
    public void deleteWarehouseman(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(getWarehousemenByID(id));
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
