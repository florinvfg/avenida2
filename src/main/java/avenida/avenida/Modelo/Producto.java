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

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaComanda> lineaComanda = new ArrayList<>();  


    //constructores
    public Producto(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Producto() {
    }

    // Getters y setters

    public Producto(int id, String marca, String modelo, List<LineaComanda> lineaComanda) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.lineaComanda = lineaComanda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

     public Object getReparaciones() {
        return null;
    }

    public void setReparaciones(Object reparaciones) {
    }

   
}
