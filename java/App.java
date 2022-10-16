import com.fasterxml.jackson.databind.ObjectMapper;
import cs.model.Contact;
import cs.model.MSettings;
import cs.start.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        new Main();

//        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        Contact contact = new Contact("Jan", "jan@wp.pl" );
//
//        session.getTransaction().begin();
//        session.saveOrUpdate(contact);
//        session.getTransaction().commit();
//        session.close();

    }
}