package hibernateDAO;

import clases.Vuelo;
import org.hibernate.Session;

import java.util.List;

public class VueloDAO {

    public static void crear(Vuelo vuelo) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.persist(vuelo);
            session.getTransaction().commit();
        }
    }

    public static void actualizar(Vuelo vuelo) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.merge(vuelo);
            session.getTransaction().commit();
        }
    }

    public static List<Vuelo> consultarVuelos() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Vuelo", Vuelo.class).list();
        }
    }

    public static List<Vuelo> consultarVuelosConAvionAeropuerto() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Vuelo v JOIN FETCH v.avion JOIN FETCH v.aeropuerto WHERE v.pasajeros > :minPasajeros";
            return session.createQuery(hql, Vuelo.class)
                    .setParameter("minPasajeros", 15)
                    .list();
        }
    }
}
