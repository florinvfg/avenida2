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
    private String precio;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaComanda> lineaComanda = new ArrayList<>();  


    //constructores
    public Producto(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto() {
    }

    // Getters y setters

    public Producto(int id, String nombre, String precio, List<LineaComanda> lineaComanda) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.lineaComanda = lineaComanda;
    }

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

    public String getPrecio() {
        return precio;
    }

    public void setModelo(String modelo) {
        this.precio = modelo;
    }

    public List<LineaComanda> getlineaComanda() {
        return lineaComanda;
    }

    public void setlineaComanda(List<LineaComanda> lineaComanda) {
        this.lineaComanda = lineaComanda;
    }

    // toString

    @Override
    public String toString() {
        return "producto{" +
                "id=" + id +
                ", nombre ='" + nombre + '\'' +
                ", precio ='" + precio + '\'' +
                '}';
    }

     public Object getReparaciones() {
        return null;
    }

    public void setReparaciones(Object reparaciones) {
    }

   

    public void setNombre(Object nombre) {
    }

    public void setPrecio(String precio2) {
    }

    public Object getLineaComanda() {
        return null;
    }

    public void setLineaComanda(Object lineaComanda2) {
    }

   
}
