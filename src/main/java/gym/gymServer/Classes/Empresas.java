package gym.gymServer.Classes;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Empresas")
@Component
public class Empresas implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mail_empresa", referencedColumnName = "mail"/*, nullable = false*/)
    private UserLogin userLoginReference;

    private String nombre;

    @Column(name = "mailEmpresa")
    private @Id String mail;

    @OneToMany(targetEntity = Empleado.class, cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<Empleado> listaEmpleados;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "empresa")
    private List<Pago> pagos;

    public Empresas(String nombre, String mail, List<Empleado> listaEmpleados) {
        this.nombre = nombre;
        this.mail = mail;
        this.listaEmpleados = listaEmpleados;
    }

    public Empresas() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public UserLogin getUserLoginReference() {
        return userLoginReference;
    }

    public void setUserLoginReference(UserLogin userLoginReference) {
        this.userLoginReference = userLoginReference;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresas empresas = (Empresas) o;
        return Objects.equals(userLoginReference, empresas.userLoginReference) && Objects.equals(nombre, empresas.nombre) && Objects.equals(mail, empresas.mail) && Objects.equals(listaEmpleados, empresas.listaEmpleados) && Objects.equals(pagos, empresas.pagos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLoginReference, nombre, mail, listaEmpleados, pagos);
    }

    @Override
    public String toString() {
        return "Empresas{" +
                "userLoginReference=" + userLoginReference +
                ", nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", listaEmpleados=" + listaEmpleados +
                ", pagos=" + pagos +
                '}';
    }
}
