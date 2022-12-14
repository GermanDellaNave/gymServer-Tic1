package gym.gymServer.Classes;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Login")
@Component
public class UserLogin implements Serializable {

    @Column(name = "mail")
    private @Id String mail;

    @Column(name = "contraseña", nullable = false)
    private String contrasena;

    private String tipoDeUsuario;

    public UserLogin() {
    }

    public UserLogin(String mail, String contrasena, String tipoDeUsuario) {
        this.mail = mail;
        this.contrasena = contrasena;
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }





    @Override
    public String toString() {
        return "UserLogin{" +
                "mail='" + mail + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", tipoDeUsuario='" + tipoDeUsuario + '\'' +
                '}';
    }
}
