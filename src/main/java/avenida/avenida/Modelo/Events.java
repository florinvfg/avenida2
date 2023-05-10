package avenida.avenida.Modelo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "events")
public class Comanda {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type="org.hibernate.type.UUIDBinaryType")
    @Column(name = "id", columnDefinition = "BINARY(16)", updatable = false, nullable = false, unique = true)
    private UUID id;


    @Column(name = "name")
    private String name;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "hour")
    private LocalTime hour;

    @Column(name = "registryDate", updatable = false, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime registryDate;

    @Column(name = "location_url")
    private String locationUrl;


    // Constructor vacío
    public Events() {
    }

// Constructor con argumentos
public Events(String name, LocalDate date, LocalTime hour, String locationUrl) {
    this.name = name;
    this.date = date;
    this.hour = hour;
    this.locationUrl = locationUrl;
}

    // Getters y setters


    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setRegistryDate(LocalDateTime registryDate) {
        this.registryDate = registryDate;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate fecha) {
        this.date = fecha;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime localTime) {
        this.hour = localTime;
    }

    public LocalDateTime getRegistryDate() {
        return registryDate;
    }

        public Events(UUID id, String name, LocalDate date, LocalTime hour, LocalDateTime registryDate,
            String locationUrl) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.registryDate = registryDate;
        this.locationUrl = locationUrl;
    }

    // Getters y setters
    public String getLocationUrl() {
        return locationUrl;
    }

    public void setLocationUrl(String locationUrl) {
        this.locationUrl = locationUrl;
    }

    // Método para asignar automáticamente la fecha y hora de registro antes de persistir
    @PrePersist
    public void prePersist() {
        this.registryDate = LocalDateTime.now();
    }
}
