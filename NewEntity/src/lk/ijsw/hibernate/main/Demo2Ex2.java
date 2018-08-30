package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Customer;
import lk.ijsw.hibernate.entity.Employee;
import lk.ijsw.hibernate.entity.Information;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Demo2Ex2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();//session factory eken objet ekak ganima


        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            Customer customer= new Customer("Athula","Kandy", new BigDecimal("102.23"));

           session.save(customer);

            session.getTransaction().commit();

        }
        sessionFactory.close();
    }
}
