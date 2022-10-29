package gym.gymServer.Classes;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Centros_Deportivos")
@Component
public class CentrosDeportivos implements Serializable {

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "usuarioLogin", referencedColumnName = "mail", nullable = false)
    private UserLogin userLogin;

    private String nombre;

    @Column(name = "mailCentro")
    private @Id String mail;

    //Eliminar
    /*@OneToMany()
    @JoinColumn(name = "listaActividad", referencedColumnName = "mailCentro")
    private List<Actividad> listaActividades;

    //Eliminar
    @OneToMany()
    @JoinColumn(name = "pagos", referencedColumnName = "mailCentro")
    private List<Pago> pagos;*/

    public CentrosDeportivos() {
    }

    public CentrosDeportivos(String nombre, String mail/*, List<Actividad> listaActividades*/) {
        this.nombre = nombre;
        this.mail = mail;
        //this.listaActividades = listaActividades;
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

    /*public List<Actividad> getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(List<Actividad> listaActividades) {
        this.listaActividades = listaActividades;
    }*/

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    /*public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CentrosDeportivos that = (CentrosDeportivos) o;
        return Objects.equals(userLogin, that.userLogin) && Objects.equals(nombre, that.nombre) && Objects.equals(mail, that.mail) ;//&& Objects.equals(listaActividades, that.listaActividades) && Objects.equals(pagos, that.pagos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLogin, nombre, mail);
    }

    @Override
    public String toString() {
        return "CentrosDeportivos{" +
                "userLogin=" + userLogin +
                ", nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
