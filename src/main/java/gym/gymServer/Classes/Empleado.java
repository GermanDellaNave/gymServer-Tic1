package gym.gymServer.Classes;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    private Date dateCreado;

    private int deuda;

    @Lob
    private String imagen;

    /*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "empleado")
    private List<InscripcionesActividades> actividadesInscripto;
*/
    public Empleado() {
    }

    public Empleado(UserLogin userLoginReference, String nombre, String apellido, String mail, String telefono, Empresas empresa, int saldoDisponible, Date dateCreado, int deuda, String imagen) {
        this.userLoginReference = userLoginReference;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = telefono;
        this.empresa = empresa;
        this.saldoDisponible = saldoDisponible;
        this.dateCreado = dateCreado;
        this.deuda = deuda;
        this.imagen = imagen;
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

    public Date getDateCreado() {
        return dateCreado;
    }

    public void setDateCreado(Date dateCreado) {
        this.dateCreado = dateCreado;
    }

    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda = deuda;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /*public List<InscripcionesActividades> getActividadesInscripto() {
        return actividadesInscripto;
    }

    public void setActividadesInscripto(List<InscripcionesActividades> actividadesInscripto) {
        this.actividadesInscripto = actividadesInscripto;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return saldoDisponible == empleado.saldoDisponible && deuda == empleado.deuda && Objects.equals(userLoginReference, empleado.userLoginReference) && Objects.equals(nombre, empleado.nombre) && Objects.equals(apellido, empleado.apellido) && Objects.equals(mail, empleado.mail) && Objects.equals(telefono, empleado.telefono) && Objects.equals(empresa, empleado.empresa) && Objects.equals(dateCreado, empleado.dateCreado) && Objects.equals(imagen, empleado.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLoginReference, nombre, apellido, mail, telefono, empresa, saldoDisponible, dateCreado, deuda, imagen);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "userLoginReference=" + userLoginReference +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", mail='" + mail + '\'' +
                ", telefono='" + telefono + '\'' +
                ", empresa=" + empresa +
                ", saldoDisponible=" + saldoDisponible +
                ", dateCreado=" + dateCreado +
                ", deuda=" + deuda +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
