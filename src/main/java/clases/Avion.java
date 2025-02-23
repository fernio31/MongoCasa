package clases;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Avion {
    @Id
    private int id;
    private String marca;
    private String modelo;
    private String aerolinea;

    @ManyToOne
    private List<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();


    public Avion(String marca, String modelo, String aerolinea) {
        this.marca = marca;
        this.modelo = modelo;
        this.aerolinea = aerolinea;
    }



    @Override
    public String toString() {
        return "Avion{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", aerolinea='" + aerolinea + '\'' +
                '}';
    }
}
