package org.example;

import clases.Aeropuerto;
import clases.Avion;
import clases.Vuelo;
import mongoDAO.MongoDBConfig;

import java.util.ArrayList;
import java.util.List;

public class Main {
    MongoDBConfig mongoDBConfig = new MongoDBConfig();
    public static void main(String[] args){
        MongoDBConfig.getCollection();
        Aeropuerto aeropuerto = new Aeropuerto("MAD", "Barajas", null, null);
        mongoDAO.AeropuertoDAO.insertAeropuerto(aeropuerto);

        Avion avion1 = new Avion("Boeing", "747", "Iberia");
        mongoDAO.AvionDAO.insertAvion(avion1);

        Avion avion2 = new Avion("Airbus", "A380", "Iberia");
        mongoDAO.AvionDAO.insertAvion(avion2);

        Vuelo vuelo = new Vuelo("1", avion1, 100.0, 10);
        mongoDAO.VueloDAO.insertVuelo(vuelo);

        Vuelo vuelo2 = new Vuelo("2", avion2, 200.0, 20);
        mongoDAO.VueloDAO.insertVuelo(vuelo2);

        List<Avion> aviones = new ArrayList<>();
        aviones.add(avion1);
        aviones.add(avion2);

        List<Vuelo> vuelos = new ArrayList<>();
        vuelos.add(vuelo);
        vuelos.add(vuelo2);

        aeropuerto.setAviones(aviones);
        aeropuerto.setVuelos(vuelos);



        vuelo.setDuracion(150.0);
        mongoDAO.VueloDAO.updateVuelo(vuelo);

        mongoDAO.AeropuertoDAO.updateAeropuerto(aeropuerto);

        System.out.println(mongoDAO.AeropuertoDAO.getAeropuertos());
        System.out.println(mongoDAO.AvionDAO.getAviones());
        System.out.println(mongoDAO.VueloDAO.getVuelos());

        System.out.println(mongoDAO.VueloDAO.getPasajeros15());
        mongoDAO.AeropuertoDAO.deleteAeropuerto(aeropuerto);


    }
}