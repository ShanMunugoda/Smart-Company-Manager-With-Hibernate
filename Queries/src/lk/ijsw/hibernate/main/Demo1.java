package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Customer;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();//session factory eken objet ekak ganima


        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
//            List<Customer> customers=session.createQuery("FROM Customer").getResultList();
//            for(Customer customer:customers){
//                System.out.println(customer);
//            }
//
//            List<Customer> customers=session.createQuery("FROM Customer",Customer.class).getResultList();
//            customers.stream().forEach(customer -> {
//                System.out.println(customer);
//            });
//
            List<Object[]>customers=session.
                    createQuery("SELECT c.id,c.name FROM Customer c").list();


            for(Object[] customer : customers){
                System.out.println(customer[0]);
            }

            session.getTransaction().commit();

        }
        sessionFactory.close();
    }
}
