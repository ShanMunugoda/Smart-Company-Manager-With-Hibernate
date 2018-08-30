package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Customer;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Demo4RemoveinJPA {
    public static void main(String[] args) {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();//session factory eken objet ekak ganima

        Session session=sessionFactory.openSession();//session factory eken session ekak open kara ganima
        session.getTransaction().begin();

      Customer customer=session.get(Customer.class,"c002");

        session.remove(customer);

        session.getTransaction().commit();

        session.close();

        sessionFactory.close();
    }
}
