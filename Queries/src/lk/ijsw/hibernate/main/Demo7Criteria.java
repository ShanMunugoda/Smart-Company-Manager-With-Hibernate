package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Customer;
import lk.ijsw.hibernate.entity.MyEntity;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Demo7Criteria {
    public static void main(String[] args) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();//session factory eken objet ekak ganima


        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();

            CriteriaBuilder builder=session.getCriteriaBuilder();
            CriteriaQuery<Customer> query=builder.createQuery(Customer.class);
            Root<Customer> root=query.from(Customer.class);
            query.select(root);

            List<Customer> customers=session.createQuery(query).list();
            customers.forEach(System.out::println);

            session.getTransaction().commit();

        }
        sessionFactory.close();
    }
}
