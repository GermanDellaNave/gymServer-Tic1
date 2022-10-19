package gym.gymServer.Classes;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
@Component
public class Usuarios{

    private String nombre;

    private String apellido;

    private @Id String mail;

    private String telefono;

    /*@ManyToOne
    @JoinColumn(name = "mailEmpresa")
    private Empresas mailEmpresa;*/

    private int saldoDisponible;

    public Usuarios() {
    }

    public Usuarios(String nombre, String apellido, String mail, String telefono, String mailEmpresa, int saldoDisponible) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = telefono;
        //this.mailEmpresa = mailEmpresa;
        this.saldoDisponible = saldoDisponible;
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

    /*public String getMailEmpresa() {
        return mailEmpresa;
    }

    public void setMailEmpresa(String mailEmpresa) {
        this.mailEmpresa = mailEmpresa;
    }*/

    public int getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
