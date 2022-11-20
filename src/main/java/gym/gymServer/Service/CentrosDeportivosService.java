package gym.gymServer.Service;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Classes.Empresas;
import gym.gymServer.Classes.Exceptions.CentroDeportivoNoExiste;
import gym.gymServer.Classes.Exceptions.CentroDeportivoYaExiste;
import gym.gymServer.Classes.Exceptions.EmpresaNoExiste;
import gym.gymServer.Classes.Exceptions.EmpresaYaExiste;
import gym.gymServer.Repository.CentrosDeportivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class CentrosDeportivosService {

    @Autowired
    private CentrosDeportivosRepository centrosDeportivosRepository;

    public CentrosDeportivosService() {
    }

    public CentrosDeportivosService(CentrosDeportivosRepository centrosDeportivosRepository) {
        this.centrosDeportivosRepository = centrosDeportivosRepository;
    }

    public List<CentrosDeportivos> getCentrosDeportivos() {
        return (List<CentrosDeportivos>) centrosDeportivosRepository.findAllByOrderByMailAsc();
    }

    public List<CentrosDeportivos> getNuevosCentros() {
        return centrosDeportivosRepository.findTopNewest();
    }

    public CentrosDeportivos getCentroDeportivo(String mail) {
        System.out.println("Buscando");
        CentrosDeportivos centro = centrosDeportivosRepository.findOneByMail(mail);
        if (centro == null) {
            System.out.println("ERROR: centro no existe");
            return null;
        } else {
            System.out.println("Busqueda Centro exitosa");
            return centro;
        }

    }

    public String getCentroDeportivoNombre(String mail) {
        System.out.println("Buscando");
        CentrosDeportivos centro = centrosDeportivosRepository.findOneByMail(mail);
        if (centro == null) {
            return null;
        } else {
            return centro.getNombre();
        }
    }

    public void registrarCentroDeportivo (CentrosDeportivos nuevoCentro)  {
       /*
        if (centrosDeportivosRepository.findOneByMail(nuevoCentro.getMail()) != null) {
            System.out.println("ERROR");
            throw new CentroDeportivoYaExiste();
        }

        */
        centrosDeportivosRepository.save(nuevoCentro);
        System.out.println("Registro Centro");
    }

    public int getCantidadCentros(){
        return centrosDeportivosRepository.getNumeroCentrosDeportivos();
    }

    public void borrarCentroDeportivo(String mailId) {
        if (centrosDeportivosRepository.findOneByMail(mailId) != null) {
            centrosDeportivosRepository.deleteById(mailId);
        }
    }

    public void actualizarDatosCD(String mailId, String nombre, String contrasena) {
        CentrosDeportivos centroActualizable = centrosDeportivosRepository.findOneByMail(mailId);

        /*
        if (centroActualizable == null) {
            throw new CentroDeportivoNoExiste();
        }

         */

        centroActualizable.setNombre(nombre);

        centrosDeportivosRepository.save(centroActualizable);
    }

    public List<CentrosDeportivos> getCentrosDeportivosLike(String search) {
        return centrosDeportivosRepository.findBySearch(search);
    }

    @Transactional
    public void actualizarCentroDeportivo(String mailCentro,CentrosDeportivos centrosDeportivos) {

        CentrosDeportivos centroDeportivoActualizable = centrosDeportivosRepository.findOneByMail(mailCentro);
        centroDeportivoActualizable.setNombre(centrosDeportivos.getNombre());
        centroDeportivoActualizable.setImagen(centrosDeportivos.getImagen());
    }
}
