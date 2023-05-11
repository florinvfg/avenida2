package avenida.avenida.Modelo;


import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "LineaComanda")
public class LineaComanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdLineaComanda")
    private int idLineaComanda;

    @ManyToOne
    @JoinColumn(name = "IdComanda")
    private Double comanda;

    @ManyToOne
    @JoinColumn(name = "IdProducto")
    private Producto producto;

    @Column(name = "udsProducto")
    private int unidadesProducto;

    // Constructor vacío
    public LineaComanda() {
    }

    // Constructor con parámetros
    public LineaComanda(Double comanda, Producto producto, int unidadesProducto) {
        this.comanda = comanda;
        this.producto = producto;
        this.unidadesProducto = unidadesProducto;
    }

    // Getters y setters

    public int getIdLineaComanda() {
        return idLineaComanda;
    }

    public void setIdLineaComanda(int idLineaComanda) {
        this.idLineaComanda = idLineaComanda;
    }

    public Double getComanda() {
        return comanda;
    }

    public void setComanda(Double comanda) {
        this.comanda = comanda;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getUnidadesProducto() {
        return unidadesProducto;
    }

    public void setUnidadesProducto(int unidadesProducto) {
        this.unidadesProducto = unidadesProducto;
    }

    public List<LineaComanda> obtenerTodasLasLineasComanda() {
        return null;
    }

    public LineaComanda obtenerLineaComandaPorId(int idLineaComanda2) {
        return null;
    }

    public LineaComanda crearLineaComanda(LineaComanda lineaComanda) {
        return null;
    }

    public LineaComanda actualizarLineaComanda(int idLineaComanda2, LineaComanda lineaComandaActualizada) {
        return null;
    }

    public void eliminarLineaComanda(int idLineaComanda2) {
    }

    public LineaComanda aupdateLineaComanda(int idLineaComanda2, LineaComanda lineaComandaActualizada) {
        return null;
    }

    public LineaComanda update(int idLineaComanda2, LineaComanda lineaComandaActualizada) {
        return null;
    }
}
