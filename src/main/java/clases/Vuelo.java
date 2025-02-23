package clases;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Vuelo {
    @Id
    private String codigo;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Avion avion;
    private double duracion;
    private int pasajeros;
    @ManyToOne
    private Aeropuerto aeropuerto;


    public Vuelo(String codigo, Avion avion, double duracion, int pasajeros) {
        this.codigo = codigo;
        this.avion = avion;
        this.duracion = duracion;
        this.pasajeros = pasajeros;
    }


    @Override
    public String toString() {
        return "Vuelo{" +
                "codigo='" + codigo + '\'' +
                ", avion=" + avion +
                ", duracion=" + duracion +
                ", pasajeros=" + pasajeros +
                '}';
    }
}
