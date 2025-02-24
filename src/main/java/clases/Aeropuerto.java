package clases;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Aeropuerto {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codigo;
    private String nombre;
    @OneToMany(mappedBy = "aeropuerto", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Vuelo> vuelos;
    @OneToMany(mappedBy = "aeropuertos", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.SET_NULL)
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
