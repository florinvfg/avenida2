package avenida.avenida.Modelo;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "comanda")
public class Comanda {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comanda", fetch = FetchType.EAGER)
    private Set<LineaComanda> lineaComandas = new HashSet<>();    
    
    @ManyToOne
    @JoinColumn(name = "IdMesa")
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "IdCamarero")
    private User idCamarero;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
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
    public Comanda() {
    }

// Constructor con parámetros
public Comanda(int id, Set<LineaComanda> lineaComandas, Mesa mesa, User idCamarero, Date date, LocalTime hour,
Date registryDate, Double importeComanda, int numComensales) {
this.id = id;
this.lineaComandas = lineaComandas;
this.mesa = mesa;
this.idCamarero = idCamarero;
this.date = date;
this.hour = hour;
this.registryDate = registryDate;
this.importeComanda = importeComanda;
this.numComensales = numComensales;
}

// Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<LineaComanda> getLineaComandas() {
        return lineaComandas;
    }

    public void setLineaComandas(Set<LineaComanda> lineaComandas) {
        this.lineaComandas = lineaComandas;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
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

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public java.util.Date getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(java.util.Date registryDate) {
        this.registryDate = registryDate;
    }

    public Double getImporteComanda() {
        if (this.lineaComandas != null && !this.lineaComandas.isEmpty()) {
            return this.lineaComandas.stream()
                    .mapToDouble(LineaComanda::getTotal)
                    .sum();
        } else {
            return null;
        }
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
//ToString
    @Override
    public String toString() {
        return "Comanda [id=" + id + ", mesa=" + mesa + ", idCamarero=" + idCamarero + ", date=" + date + ", hour="
                + hour + ", registryDate=" + registryDate + ", importeComanda=" + importeComanda + ", numComensales="
                + numComensales + ", lineaComandas=" + lineaComandas + "]";
    }
}