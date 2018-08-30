package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Customer;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Demo5 {
    public static void main(String[] args) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();//session factory eken objet ekak ganima


        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
            session.createNamedQuery("query6")
                    .setParameter(1,"c020")
                    .setParameter(2,"MADUROX")
                    .setParameter(3,"Galle")
                    .setParameter(4,4577)
                    .executeUpdate();




            session.getTransaction().commit();

        }
        sessionFactory.close();
    }
}
