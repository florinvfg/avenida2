package avenida.avenida.Modelo;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import java.sql.Date;
import java.util.List;

@Table(name = "clientes")
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private int telefono;

    @Column(name = "dni")
    private String dni;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;

    @Column(name = "estatura")
    private double estatura;

    @Column(name = "peso")
    private double peso;

    @Column(name = "consentimiento")
    private boolean consentimiento;

    @Column(name = "fecha_consentimiento")
    private Date fecha_consentimiento;


    public Cliente() {
    }

    public Cliente(Long id, String nombre, String apellidos, String email, int telefono, String dni, String sexo,
            Date fecha_nacimiento, double estatura, double peso, boolean consentimiento, Date fecha_consentimiento,
            List<Bicicleta> bicicletas) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.dni = dni;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estatura = estatura;
        this.peso = peso;
        this.consentimiento = consentimiento;
        this.fecha_consentimiento = fecha_consentimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isConsentimiento() {
        return consentimiento;
    }

    public void setConsentimiento(boolean consentimiento) {
        this.consentimiento = consentimiento;
    }

    public Date getFecha_consentimiento() {
        return fecha_consentimiento;
    }

    public void setFecha_consentimiento(Date fecha_consentimiento) {
        this.fecha_consentimiento = fecha_consentimiento;
    }


 
    
}