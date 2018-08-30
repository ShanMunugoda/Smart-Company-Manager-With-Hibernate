package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Customer;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Demo10Checkstate {
    public static void main(String[] args) {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();//session factory eken objet ekak ganima


        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
Customer customer=session.get(Customer.class,"c001");
            session.detach(customer);

            Customer newCustomer=(Customer)session.merge(customer);

            System.out.println("Customer manage state :"+ session.contains(customer));
            System.out.println("newCustomer manage state :"+ session.contains(newCustomer));

            session.getTransaction().commit();

        }
        sessionFactory.close();
    }
}
