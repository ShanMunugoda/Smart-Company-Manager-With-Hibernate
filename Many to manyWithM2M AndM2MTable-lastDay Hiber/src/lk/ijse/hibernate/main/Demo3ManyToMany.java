package lk.ijse.hibernate.main;



import lk.ijse.hibernate.entity.Item;
import lk.ijse.hibernate.entity.Order;
import lk.ijse.hibernate.entity.OrderDetails;
import lk.ijse.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class Demo3ManyToMany {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            session.beginTransaction();


           Item item1=new Item(323,12,100,"Haal");
            Item item2 = new Item(661, 2, 34, "ggukg");

            session.persist(item1);
            session.persist(item2);

            Order order=new Order(771,new Date());

            session.persist(order);

            order.getOrderDetails().add(new OrderDetails(order.getId(),item1.getCode(),5));

            order.getOrderDetails().add(new OrderDetails(order.getId(),item2.getCode(),5));

            session.persist(order);



            session.getTransaction().commit();


        }

        sessionFactory.close();

    }

}
