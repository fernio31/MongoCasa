package hibernateDAO;

import clases.Avion;
import org.hibernate.Session;

import java.util.List;

public class AvionDAO {

    public static void crear(Avion avion) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.persist(avion);
            session.getTransaction().commit();
        }
    }

    public static void actualizar(Avion avion) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.merge(avion);
            session.getTransaction().commit();
        }
    }

    public static List<Avion> consultarAviones() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Avion", Avion.class).list();
        }
    }
}
