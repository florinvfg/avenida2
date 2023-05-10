package avenida.avenida.Modelo;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "Comanda")

public class Comanda {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IdMesa")
    private int idMesa;
   
    @ManyToOne
    @JoinColumn(name = "IdCamarero")
    private UUID idCamarero;

    @Column(name = "UUID")
    private String uuid;

    @Column(name = "Date")
    private java.util.Date date;

    @Column(name = "Hour")
    private java.util.Date hour;

    @Column(name = "RegistryDate")
    private java.util.Date registryDate;

    @Column(name = "ImporteComanda")
    private Double importeComanda;

    @Column(name = "NumComensales")
    private int numComensales;

    // Constructor vacío
    public Comanda() {
    }

    // Constructor con parámetros
    public Comanda(int idMesa, UUID idCamarero, String uuid, java.util.Date date, java.util.Date hour,
                   java.util.Date registryDate, Double importeComanda, int numComensales) {
        this.idMesa = idMesa;
        this.idCamarero = idCamarero;
        this.uuid = uuid;
        this.date = date;
        this.hour = hour;
        this.registryDate = registryDate;
        this.importeComanda = importeComanda;
        this.numComensales = numComensales;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public UUID getIdCamarero() {
        return idCamarero;
    }

    public void setIdCamarero(UUID idCamarero) {
        this.idCamarero = idCamarero;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public java.util.Date getHour() {
        return hour;
    }

    public void setHour(java.util.Date hour) {
        this.hour = hour;
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

    public void setImporteComanda(Double importeComanda) {
        this.importeComanda = importeComanda;
    }

    public int getNumComensales() {
        return numComensales;
    }

    public void setNumComensales(int numComensales) {
        this.numComensales = numComensales;
    }
}