package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Customer;
import lk.ijsw.hibernate.entity.Employee;
import lk.ijsw.hibernate.entity.Information;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;

public class Demo3Ex3Blob {
    public static void main(String[] args) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();//session factory eken objet ekak ganima


        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
            Customer customer=session.get(Customer.class,1);

            //database eke athi image eka binary ekakata convert karala e binary eka inputsream ekaka(is) eke store karagannawa
            InputStream is=customer.getProfilePic().getBinaryStream();

            //create a byte array of the size of the inputStream
            byte[] bis=new byte[is.available()];

            //read all data from inputStream andinsert to byte array
            is.read(bis);

            File file=new File("C:/Users/SDMROX/Desktop/cart/1.jpg");

            FileOutputStream fos=new FileOutputStream(file);

            fos.write(bis);

            fos.close();

            System.out.println(customer);


            session.getTransaction().commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sessionFactory.close();
    }
}
