package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Customer;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Demo4 {
    public static void main(String[] args) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();//session factory eken objet ekak ganima


        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
//            List<Customer> customers=session.getNamedQuery("query1").list();//name query is in entity->CustomerFile
//
//            customers.stream().forEach(System.out::println);

            Customer customer=(Customer)session.createNamedQuery("query2").setParameter("id","c001").uniqueResult();
            System.out.println(customer);

            session.getTransaction().commit();

        }
        sessionFactory.close();
    }
}
