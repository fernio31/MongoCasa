package hibernateDAO;

import clases.Aeropuerto;
import org.hibernate.Session;

import java.util.List;

public class AeropuertoDAO {
    public static void crear(Aeropuerto aeropuerto) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.persist(aeropuerto);
            session.getTransaction().commit();
        }
    }

    public static void actualizar(Aeropuerto aeropuerto) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.merge(aeropuerto);
            session.getTransaction().commit();
        }
    }

    public static List<Aeropuerto> leerTodos() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Aeropuerto", Aeropuerto.class).list();
        }
    }

    public static void delete(Aeropuerto aeropuerto) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.remove(aeropuerto);
            session.getTransaction().commit();
        }
    }

}
