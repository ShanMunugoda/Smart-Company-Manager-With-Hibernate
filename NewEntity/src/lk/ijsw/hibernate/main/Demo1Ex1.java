package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Customer;
import lk.ijsw.hibernate.entity.Employee;
import lk.ijsw.hibernate.entity.Information;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.Date;


public class Demo1Ex1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();//session factory eken objet ekak ganima


        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
            Information ranga=new Information("Ranga","Lamkathilaka",new Date());
            Information rangaKalla=new Information("Sigi","Lankathilaka",new Date());

            Employee employeeRanga=new Employee(ranga,rangaKalla,"Galle");

            session.save(employeeRanga);

            session.getTransaction().commit();

        }
        sessionFactory.close();
    }
}
