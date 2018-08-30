package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.MyEntity;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import java.util.List;

public class Demo6 {
    public static void main(String[] args) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();//session factory eken objet ekak ganima


        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
            List<MyEntity> customerInfo=session.createNativeQuery("SELECT c.id,c.name FROM Customer c")
                    .setResultTransformer(Transformers.aliasToBean(MyEntity.class))
                    .list();

            customerInfo.stream().forEach(System.out::println);
            session.getTransaction().commit();

        }
        sessionFactory.close();
    }
}
