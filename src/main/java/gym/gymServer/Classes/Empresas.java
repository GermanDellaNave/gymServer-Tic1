package gym.gymServer.Classes;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Empresas")
@Component
public class Empresas implements Serializable {

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_login", referencedColumnName = "mail"/*, nullable = false*/)
    private UserLogin userLoginReference;

    private String nombre;

    private Integer bono;

    @Column(name = "mailEmpresa")
    private @Id String mail;

    @Lob
    private String imagen;

    private Date dateCreada;


    public Empresas(UserLogin userLoginReference, String nombre, Integer bono, String mail, String imagen, Date dateCreada) {
        this.userLoginReference = userLoginReference;
        this.nombre = nombre;
        this.bono = bono;
        this.mail = mail;
        this.imagen = imagen;
        this.dateCreada = dateCreada;
    }

    public Empresas() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getBono() {
        return bono;
    }

    public void setBono(Integer bono) {
        this.bono = bono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public UserLogin getUserLoginReference() {
        return userLoginReference;
    }

    public void setUserLoginReference(UserLogin userLoginReference) {
        this.userLoginReference = userLoginReference;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getDateCreada() {
        return dateCreada;
    }

    public void setDateCreada(Date dateCreada) {
        this.dateCreada = dateCreada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresas empresas = (Empresas) o;
        return Objects.equals(userLoginReference, empresas.userLoginReference) && Objects.equals(nombre, empresas.nombre) && Objects.equals(bono, empresas.bono) && Objects.equals(mail, empresas.mail) && Objects.equals(imagen, empresas.imagen) && Objects.equals(dateCreada, empresas.dateCreada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLoginReference, nombre, bono, mail, imagen, dateCreada);
    }

    @Override
    public String toString() {
        return "Empresas{" +
                "userLoginReference=" + userLoginReference +
                ", nombre='" + nombre + '\'' +
                ", bono=" + bono +
                ", mail='" + mail + '\'' +
                ", imagen='" + imagen + '\'' +
                ", dateCreada=" + dateCreada +
                '}';
    }
}
