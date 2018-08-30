package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Customer;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Demo5EagervsLazey {
    public static void main(String[] args) {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();//session factory eken objet ekak ganima


        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();

//            Customer customer=session.get(Customer.class,"c001");
//
//            System.out.println(customer);

            Customer customer=session.load(Customer.class,"c001");

            System.out.println(customer.getId());

            System.out.println("============");

            System.out.println(customer.getName());

            session.getTransaction().commit();
        }



        sessionFactory.close();
    }
}
