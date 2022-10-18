package gym.gymServer.Classes;

import javax.persistence.Entity;
import java.util.Objects;

public class UserRegistro {
    private String mail;
    private String contrasena;

    public UserRegistro(String mail, String contrasena) {
        this.mail = mail;
        this.contrasena = contrasena;
    }

    public String getMail() {
        return mail;
    }

    public String getContrasena() {
        return contrasena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRegistro that = (UserRegistro) o;
        return Objects.equals(mail, that.mail) && Objects.equals(contrasena, that.contrasena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail, contrasena);
    }

    @Override
    public String toString() {
        return "UserRegistro{" +
                "mail='" + mail + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
