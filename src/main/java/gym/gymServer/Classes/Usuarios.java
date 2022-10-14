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

    @OneToOne
    private Empresas empresa;

    private int saldoDisponible;

    public Usuarios() {
    }

    public Usuarios(String nombre, String apellido, String mail, Empresas empresa, int saldoDisponible) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.empresa = empresa;
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
}
