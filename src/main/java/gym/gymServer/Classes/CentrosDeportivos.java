package gym.gymServer.Classes;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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

    @Lob
    private String imagen;

    private Date dateCreado;


    public CentrosDeportivos() {
    }

    public CentrosDeportivos(UserLogin userLogin, String nombre, String mail, String imagen, Date dateCreado) {
        this.userLogin = userLogin;
        this.nombre = nombre;
        this.mail = mail;
        this.imagen = imagen;
        this.dateCreado = dateCreado;
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

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getDateCreado() {
        return dateCreado;
    }

    public void setDateCreado(Date dateCreado) {
        this.dateCreado = dateCreado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CentrosDeportivos that = (CentrosDeportivos) o;
        return Objects.equals(userLogin, that.userLogin) && Objects.equals(nombre, that.nombre) && Objects.equals(mail, that.mail) && Objects.equals(imagen, that.imagen) && Objects.equals(dateCreado, that.dateCreado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLogin, nombre, mail, imagen, dateCreado);
    }

    @Override
    public String toString() {
        return "CentrosDeportivos{" +
                "userLogin=" + userLogin +
                ", nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", imagen='" + imagen + '\'' +
                ", dateCreado=" + dateCreado +
                '}';
    }
}
