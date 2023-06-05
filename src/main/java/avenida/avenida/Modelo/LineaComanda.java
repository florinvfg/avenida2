package avenida.avenida.Modelo;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//LineaComandas
@Entity
@Table(name = "lineaComanda")
public class LineaComanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_comanda", nullable = false)
    private Comanda comanda;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(name = "concepto")
    private String concepto;

    @Column(name = "unidades")
    private int unidades;

    @Column(name = "estado")
    private String estado;

    @Column(name = "importe")
    private double importe;

    @Column(name = "iva")
    private int iva;

    @Column(name = "total")
    private double total;

    // getter y setter para Comanda
    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

//Constructors
    public LineaComanda() {
    }

    public LineaComanda(int id, Comanda comanda, Producto producto, String concepto, int unidades, String estado,
            double importe, int iva, double total) {
        this.id = id;
        this.comanda = comanda;
        this.producto = producto;
        this.concepto = concepto;
        this.unidades = unidades;
        this.estado = estado;
        this.importe = importe;
        this.iva = iva;
        this.total = total;
    }
    
//Getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
//ToString
    @Override
    public String toString() {
        return "LineaComanda [id=" + id + ", comanda=" + comanda + ", producto=" + producto + ", concepto=" + concepto
                + ", unidades=" + unidades + ", estado=" + estado + ", importe=" + importe + ", iva=" + iva + ", total="
                + total + "]";
    }
}