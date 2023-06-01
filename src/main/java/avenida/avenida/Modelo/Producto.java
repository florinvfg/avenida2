package avenida.avenida.Modelo;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//bicicleta
@Table(name = "producto")
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private double precio;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaComanda> lineaComanda = new ArrayList<>();


    //constructores
    public Producto(int id, String nombre, double precio, List<LineaComanda> lineaComanda) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.lineaComanda = lineaComanda;
    }


    public Producto() {
    }

//getter y setter
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public List<LineaComanda> getLineaComanda() {
        return lineaComanda;
    }


    public void setLineaComanda(List<LineaComanda> lineaComanda) {
        this.lineaComanda = lineaComanda;
    }

//ToString
  
@Override
public String toString() {
    return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", lineaComanda=" + lineaComanda
            + "]";
}   
}
