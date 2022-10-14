package gym.gymServer.Classes;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "Login")
@Component
public class Login {

    @Column(name = "mail")
    private @Id String mail;

    private String contrasena;

    private String tipoDeUsuario;

    public Login() {
    }

    public Login(String mail, String contrasena, String tipoDeUsuario) {
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
}
