package avenida.avenida.Modelo;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;
//events

@ComponentScan
@Entity
@Table(name = "comanda")
public class Comanda {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "IdMesa")
    private Mesa mesa;

   
    @ManyToOne
    @JoinColumn(name = "IdCamarero")
    private User idCamarero;


    @Column(name = "Date")
    private java.util.Date date;

    @Column(name = "Hour")
    private LocalTime hour;

    @Column(name = "RegistryDate")
    private java.util.Date registryDate;

    @Column(name = "ImporteComanda")
    private Double importeComanda;

    @Column(name = "NumComensales")
    private int numComensales;

    // Constructor vacío
    public Comanda(Mesa mesa2, Producto producto, LocalDate date2, LocalTime hour2) {
    }

    // Constructor con parámetros
    public Comanda(Mesa idMesa, User idCamarero, String uuid, java.util.Date date, LocalTime hour,
                   java.util.Date registryDate, Double importeComanda, int numComensales) {
        this.mesa = idMesa;
        this.idCamarero = idCamarero;
        this.date = date;
        this.hour = hour;
        this.registryDate = registryDate;
        this.importeComanda = importeComanda;
        this.numComensales = numComensales;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mesa getIdMesa() {
        return mesa;
    }

    public void setIdMesa(Mesa idMesa) {
        this.mesa = idMesa;
    }

    
    public User getIdCamarero() {
        return idCamarero;
    }

    public void setIdCamarero(User idCamarero) {
        this.idCamarero = idCamarero;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime localTime) {
        this.hour = localTime;
    }

    public java.util.Date getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(java.util.Date registryDate) {
        this.registryDate = registryDate;
    }

    public Double getImporteComanda() {
        return importeComanda;
    }

    public void setImporteComanda(Double comanda) {
        this.importeComanda = comanda;
    }

    public int getNumComensales() {
        return numComensales;
    }

    public void setNumComensales(int numComensales) {
        this.numComensales = numComensales;
    }

    public Object getModelo() {
        return null;
    }

    public Object getLineaComanda() {
        return null;
    }

    public void setLineaComanda(Object lineaComanda) {
    }

    public void setProducto(Producto producto) {
    }

    public void save(Comanda event) {
    }

    public List<Comanda> findAll() {
        return null;
    }

    public Comanda findById(UUID id2) {
        return null;
    }

    public Optional<Comanda> findByUuidString(String id2) {
        return null;
    }

    public Object getName() {
        return null;
    }

    public void setName(Object name) {
    }

    public Object getLocationUrl() {
        return null;
    }

    public void setLocationUrl(Object locationUrl) {
    }

    public static void saveComanda(Comanda comanda) {
    }

}