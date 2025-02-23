package clases;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Aeropuerto {
    @Id
    private String codigo;
    private String nombre;
    @OneToMany(mappedBy = "aeropuerto", cascade = CascadeType.ALL)
    private List<Vuelo> vuelos;
    @OneToMany(mappedBy = "avion", cascade = CascadeType.ALL)
    private List<Avion> aviones;


    public Aeropuerto(String codigo, String nombre, List<Vuelo> vuelos, List<Avion> aviones) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.vuelos = vuelos;
        this.aviones = aviones;
    }


    @Override
    public String toString() {
        return "Aeropuerto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", vuelos=" + vuelos +
                ", aviones=" + aviones +
                '}';
    }
}
