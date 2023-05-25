package avenida.avenida.Modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mesa")
public class Mesa {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

   @Column(name = "location_url")
    private String locationUrl;


    @Column(name = "numComensales")
    private int numComensales;
    
    // Constructor vacío
    public Mesa() {
    }

// Constructor con argumentos
public Mesa(int id, int numComensales, String locationUrl) {
    this.numComensales = numComensales;
    this.id = id;
    this.locationUrl = locationUrl;
}

   // Getters y setters


//toString
    @Override
    public String toString() {
        return "Mesa [id=" + id + ", locationUrl=" + locationUrl + ", numComensales=" + numComensales + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationUrl() {
        return locationUrl;
    }

    public void setLocationUrl(String locationUrl) {
        this.locationUrl = locationUrl;
    }

    public int getNumComensales() {
        return numComensales;
    }

    public void setNumComensales(int numComensales) {
        this.numComensales = numComensales;
    }

   
    }

