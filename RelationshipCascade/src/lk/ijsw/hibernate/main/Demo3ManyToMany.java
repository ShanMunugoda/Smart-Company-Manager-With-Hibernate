package lk.ijsw.hibernate.main;


import lk.ijsw.hibernate.entity.Actor;
import lk.ijsw.hibernate.entity.GenderType;
import lk.ijsw.hibernate.entity.Movie;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class Demo3ManyToMany {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            Actor bajee=new Actor("bajee", GenderType.MALE);
            Actor tharaka=new Actor("tharaka", GenderType.MALE);

            Movie movie1=new Movie("Bahubali","Action",new Date());
            Movie movie2=new Movie("Koi mil Gaya","Action",new Date());


            bajee.addMovie(movie1);
            bajee.addMovie(movie2);

            session.persist(bajee);
            session.getTransaction().commit();

        }

        sessionFactory.close();

    }

}
