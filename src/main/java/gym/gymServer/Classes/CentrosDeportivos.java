package gym.gymServer.Classes;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Centros_Deportivos")
@Component
public class CentrosDeportivos implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioLogin", referencedColumnName = "mail", nullable = false)
    private UserLogin userLogin;

    private String nombre;

    @Column(name = "mailCentro")
    private @Id String mail;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Actividades.class, mappedBy = "centroDeportivo")
    private List<Actividades> listaActividades;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "centroDeportivo")
    private List<Pago> pagos;

    public CentrosDeportivos() {
    }

    public CentrosDeportivos(String nombre, String mail, List<Actividades> listaActividades) {
        this.nombre = nombre;
        this.mail = mail;
        this.listaActividades = listaActividades;
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

    public List<Actividades> getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(List<Actividades> listaActividades) {
        this.listaActividades = listaActividades;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
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
        CentrosDeportivos that = (CentrosDeportivos) o;
        return Objects.equals(userLogin, that.userLogin) && Objects.equals(nombre, that.nombre) && Objects.equals(mail, that.mail) && Objects.equals(listaActividades, that.listaActividades) && Objects.equals(pagos, that.pagos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLogin, nombre, mail, listaActividades, pagos);
    }

    @Override
    public String toString() {
        return "CentrosDeportivos{" +
                "userLogin=" + userLogin +
                ", nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", listaActividades=" + listaActividades +
                ", pagos=" + pagos +
                '}';
    }
}
