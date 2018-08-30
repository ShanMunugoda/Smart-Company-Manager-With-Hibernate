package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Customer;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();//session factory eken objet ekak ganima


        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();

            Customer customer1=session.createQuery("FROM Customer WHERE id='c001'",Customer.class).uniqueResult();//Hibernate
            Customer customer2=session.createQuery("FROM Customer WHERE id='c001'",Customer.class).getSingleResult();//JPA

            System.out.println(customer1);
            System.out.println(customer2);

            
            session.getTransaction().commit();

        }
        sessionFactory.close();
    }
}
