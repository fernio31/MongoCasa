package hibernateDAO;

import clases.Aeropuerto;
import clases.Avion;
import clases.Vuelo;

public class MainHibernate {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();

        Aeropuerto aeropuerto = new Aeropuerto("MAD", "Barajas", null, null);
        try {
            AeropuertoDAO.crear(aeropuerto);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al crear aeropuerto");
        }

        Avion avion1 = new Avion("Boeing", "747", "Iberia");
        Avion avion2 = new Avion("Airbus", "A380", "Iberia");
        try {
            AvionDAO.crear(avion1);
            AvionDAO.crear(avion2);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al crear avion");
        }

        Vuelo vuelo = new Vuelo("1", avion1, 100.0, 10);
        Vuelo vuelo2 = new Vuelo("2", avion2, 200.0, 20);
        try {
            VueloDAO.crear(vuelo);
            VueloDAO.crear(vuelo2);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al crear vuelo");
        }

        vuelo.setDuracion(150.0);
        try{
            VueloDAO.actualizar(vuelo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al actualizar vuelo");
        }
        try {
            AeropuertoDAO.leerTodos();
            AvionDAO.consultarAviones();
            VueloDAO.consultarVuelos();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al consultar aeropuertos, aviones o vuelos");
        }

        try {
            VueloDAO.consultarVuelosConAvionAeropuerto();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al consultar vuelos con avion y aeropuerto");
        }

        try {
            AeropuertoDAO.delete(aeropuerto);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al borrar aeropuerto");
        }

    }
}
