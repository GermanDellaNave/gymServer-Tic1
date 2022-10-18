package gym.gymServer.Classes;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Empresas")
@Component
public class Empresas{

    private String nombre;

    @Column(name = "mailEmpresa")
    private @Id String mail;

    @OneToMany
    private List<Usuarios> listaUsuarios;

    //private List<Integer> listaSaldo;

    public Empresas(String nombre, String mail, List<Usuarios> listaUsuarios/*, List<Integer> listaSaldo*/) {
        this.nombre = nombre;
        this.mail = mail;
        this.listaUsuarios = listaUsuarios;
        //this.listaSaldo = listaSaldo;
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

    public List<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    /*public List<Integer> getListaSaldo() {
        return listaSaldo;
    }

    public void setListaSaldo(List<Integer> listaSaldo) {
        this.listaSaldo = listaSaldo;
    }*/
}
