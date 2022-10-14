package gym.gymServer.Classes;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Centros_Deportivos")
@Component
public class CentrosDeportivos {

    @OneToOne
    private Login login;

    private String nombre;

    private @Id String mail;

    @OneToMany
    private List<Actividades> listaActividades;

    /*private List<Integer, CentrosDeportivos> listaSaldo;*/

    public CentrosDeportivos() {
    }

    public CentrosDeportivos(String nombre, String mail, List<Actividades> listaActividades/*, List<Integer> listaSaldo*/) {
        this.nombre = nombre;
        this.mail = mail;
        this.listaActividades = listaActividades;
        //this.listaSaldo = listaSaldo;
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
/*
    public List<Integer> getListaSaldo() {
        return listaSaldo;
    }

    public void setListaSaldo(List<Integer> listaSaldo) {
        this.listaSaldo = listaSaldo;
    }*/
}
