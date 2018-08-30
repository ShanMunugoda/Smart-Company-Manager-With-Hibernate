package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Employer;
import lk.ijsw.hibernate.entity.Spouse;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;

public class OneToOne {
    public static void main(String[] args) {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            Employer employer=new Employer("ranlkanda","Galle");
            Spouse shashi=new Spouse("AMritha",employer);

            session.save(employer);
            session.save(shashi);

            session.getTransaction().commit();

        }

        sessionFactory.close();
    }
}
