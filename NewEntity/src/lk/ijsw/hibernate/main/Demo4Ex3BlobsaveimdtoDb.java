package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Customer;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.BlobProxy;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;

public class Demo4Ex3BlobsaveimdtoDb {
    public static void main(String[] args) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();//session factory eken objet ekak ganima


        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();

//            Path path= Paths.get("E:/Wallpapers/Full HD/233b460690607b8584a6b44f8ae95b2e_large.jpeg");
//
//            byte[] bytes= Files.readAllBytes(path);
//
//            Blob KullaPic= BlobProxy.generateProxy(bytes);
//
//            Customer kulla=new Customer("Kulla","Moratu",new BigDecimal("1234.098"),
//                    KullaPic
//            );
//            session.save(kulla);


            File file=new File("E:/Wallpapers/Full HD/animal hd wallpapers 76.jpg");
            FileInputStream fis=new FileInputStream(file);

            Blob RangayPic=BlobProxy.generateProxy(fis,fis.available());

            Customer rangay=new Customer("Rangay","Horana",new BigDecimal("12312.098"),
                    RangayPic
            );
            session.save(rangay);
            session.getTransaction().commit();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//         catch (IOException e) {
//            e.printStackTrace();
//        }
        sessionFactory.close();
    }
}
