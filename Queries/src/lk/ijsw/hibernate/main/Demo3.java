package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Customer;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Demo3 {
    public static void main(String[] args) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();//session factory eken objet ekak ganima


        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();




            //positonal Parameters
//            Customer customer=session.createQuery("FROM Customer c WHERE c.id=?1",Customer.class)
//                    .setParameter(1,"c001").uniqueResult();

            //Named Parameters
            String customerId="c005";
            Customer customer=session.createQuery("FROM Customer c WHERE c.id=:customer_id",Customer.class)
                    .setParameter("customer_id",customerId).uniqueResult();

            System.out.println(customer);

            session.getTransaction().commit();

        }
        sessionFactory.close();
    }
}
