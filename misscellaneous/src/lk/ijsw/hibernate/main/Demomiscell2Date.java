package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Customer;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class Demomiscell2Date {
    public static void main(String[] args) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();//session factory eken objet ekak ganima


        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();

           Customer customer=new Customer("Suranga","Galle",new Date());
           session.persist(customer);
            System.out.println(customer.getId());

            session.getTransaction().commit();

        }
        sessionFactory.close();
    }
}
