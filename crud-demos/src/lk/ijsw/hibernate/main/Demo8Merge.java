package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Customer;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Demo8Merge {
    public static void main(String[] args) {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();//session factory eken objet ekak ganima


        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();


    Customer customer=session.get(Customer.class,"c001");


    session.detach(customer);//customer detach kala

    Customer newCustomer=(Customer)session.merge(customer);
    newCustomer.setName("Upul");
            session.getTransaction().commit();
        }



        sessionFactory.close();
    }
}
