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
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codigo;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "avion_id")
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
