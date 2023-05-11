package avenida.avenida.Modelo;


import javax.persistence.*;

@Entity
@Table(name = "mesa")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "num_comensales")
    private int numComensales;

    public Mesa() {
    }

    public Mesa(String ubicacion, int numComensales) {
        this.ubicacion = ubicacion;
        this.numComensales = numComensales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getNumComensales() {
        return numComensales;
    }

    public void setNumComensales(int numComensales) {
        this.numComensales = numComensales;
    }
}
