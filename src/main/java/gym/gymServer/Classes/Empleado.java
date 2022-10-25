package gym.gymServer.Classes;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Empleados"/* uniqueConstraints = {@UniqueConstraint(name = "uniqueConstraint", columnNames = "nombre")}*/)
@Component
public class Empleado {

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "usuarioLogin", referencedColumnName = "mail", nullable = false)
    private UserLogin userLoginReference;

    private String nombre;

    private String apellido;

    @Column(name = "mailEmpleado")
    private @Id String mail;

    private String telefono;

    @ManyToOne()
    @JoinColumn(name = "empresa_mail", referencedColumnName = "mailEmpresa")
    private Empresas empresa;

    private int saldoDisponible;

    private int saldoOriginal;

    private int deuda;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "empleado")
    private List<InscripcionesActividades> actividadesInscripto;

    public Empleado() {
    }

    public Empleado(UserLogin userLoginReference, String nombre, String apellido, String mail, String telefono, Empresas empresa, int saldoDisponible, int saldoOriginal, int deuda) {
        this.userLoginReference = userLoginReference;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = telefono;
        this.empresa = empresa;
        this.saldoDisponible = saldoDisponible;
        this.saldoOriginal = saldoOriginal;
        this.deuda = deuda;
    }

    public UserLogin getUserLoginReference() {
        return userLoginReference;
    }

    public void setUserLoginReference(UserLogin userLoginReference) {
        this.userLoginReference = userLoginReference;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }

    public int getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public int getSaldoOriginal() {
        return saldoOriginal;
    }

    public void setSaldoOriginal(int saldoOriginal) {
        this.saldoOriginal = saldoOriginal;
    }

    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda = deuda;
    }
}
